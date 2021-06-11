/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static data.DataCache.laneChangeCount;
import static data.DataCache.largeLossPayouts;
import static data.DataCache.totalLaneChangePayout;
import static data.DataCache.totalYieldPayout;
import static data.DataCache.yieldCount;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author chase
 */
public class ManagerController implements Initializable {
    
    Stage stage;
    Parent scene;
    
    public void SceneChange(String string) throws IOException {
        scene = FXMLLoader.load(getClass().getResource(string));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    @FXML
    private Label dashboardLabel;

    @FXML
    private Button backBtn;
    
    @FXML
    private Button averagePayoutBtn;

    @FXML
    private Button frequencyBtn;
    
    @FXML
    private Button totalPayoutBtn;
    
    @FXML
    private Button largeLossBtn;
    
    @FXML
    private PieChart pieChart;

    @FXML
    //most frequent loss type
    void onFrequencyClick(ActionEvent event) { 
        pieChart.setTitle("Frequency of Loss Type");
        ObservableList<PieChart.Data> pieListFrequency = FXCollections.observableArrayList(
            new PieChart.Data("Lane Change - " + laneChangeCount, laneChangeCount),
            new PieChart.Data("Intersection - " + yieldCount, yieldCount)
        );
        pieChart.setData(pieListFrequency);
    }
    
    @FXML
    //most expensive loss type by average payout
    //demonstrates how relatively expensive a loss is
    void onAveragePayoutClick(ActionEvent event) {
        double averageLaneChangePayout = totalLaneChangePayout/laneChangeCount;
        double averageYieldPayout = totalYieldPayout/yieldCount;
        String type1Format = new DecimalFormat("$###,####,###.0#").format(averageLaneChangePayout);
        String type2Format = new DecimalFormat("$###,####,###.0#").format(averageYieldPayout);
        pieChart.setTitle("Average Payout by Loss Type");
        ObservableList<PieChart.Data> pieListAveragePayout = FXCollections.observableArrayList(
            new PieChart.Data("Lane Change - " + type1Format, averageLaneChangePayout),
            new PieChart.Data("Intersection - " + type2Format, averageYieldPayout)
        );
        pieChart.setData(pieListAveragePayout);
    }

    @FXML
    void onBackBtnClick(ActionEvent event) throws IOException {
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        SceneChange("/view/LaunchScreen.fxml");
    }
    
    @FXML
    //propportion of total payout by loss type
    void onTotalPayoutBtnClick(ActionEvent event) {
        String type1Format = new DecimalFormat("$###,####,###.0#").format(totalLaneChangePayout);
        String type2Format = new DecimalFormat("$###,####,###.0#").format(totalYieldPayout);
        pieChart.setTitle("Total Payout by Loss Type");
        ObservableList<PieChart.Data> pieListAveragePayout = FXCollections.observableArrayList(
            new PieChart.Data("Lane Change - " + type1Format, totalLaneChangePayout),
            new PieChart.Data("Intersection - " + type2Format, totalYieldPayout)
        );
        pieChart.setData(pieListAveragePayout);
    }

    @FXML
    //proportion of losses that have a higher than average payout (large losses)
    void onLargeLossBtnClick(ActionEvent event) {
        double totalPayout = totalLaneChangePayout + totalYieldPayout;
        double allOtherLosses = totalPayout - largeLossPayouts;
        String type1Format = new DecimalFormat("$###,####,###.0#").format(largeLossPayouts);
        String type2Format = new DecimalFormat("$###,####,###.0#").format(allOtherLosses);
        pieChart.setTitle("Large Loss Impact on Total Payout");
        ObservableList<PieChart.Data> pieListLargeLoss = FXCollections.observableArrayList(
            new PieChart.Data("Large Losses - "+ type1Format, largeLossPayouts),
            new PieChart.Data("All Other Losses - " + type2Format, allOtherLosses)
        );
        pieChart.setData(pieListLargeLoss);
    }
    
    //Most frequent loss type in a given state not implemented in MVP.
    //Too granular for day-to-day operations
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
