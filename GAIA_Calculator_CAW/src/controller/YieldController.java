/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.DataCache;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.YieldLoss;

/**
 *
 * @author chase
 */
public class YieldController implements Initializable {
    
    Stage stage;
    Parent scene;
    
    int ivAction = 1;
    int cvAction = 1;
    int cvLocation = 2;
    int ivPOI = 1;
    int cvPOI = 1;
    int minLiab;
    boolean ivFirst = false;
    
    public void SceneChange(String string) throws IOException {
        scene = FXMLLoader.load(getClass().getResource(string));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    @FXML
    private RadioButton ivFrontRB;

    @FXML
    private RadioButton ivRearRB;

    @FXML
    private ToggleGroup cvLocationTOG;

    @FXML
    private ToggleGroup cvPOITOG;

    @FXML
    private RadioButton cvStraightRB;

    @FXML
    private ToggleGroup cvActionTOG;

    @FXML
    private RadioButton ivFirstNoRB;

    @FXML
    private RadioButton cvRightRB;

    @FXML
    private RadioButton ivStraightRB;

    @FXML
    private ToggleGroup ivPOITOG;

    @FXML
    private RadioButton cvLane3RB;

    @FXML
    private RadioButton cvLane1RB;

    @FXML
    private RadioButton cvLane2RB;

    @FXML
    private ToggleGroup ivActionTOG;

    @FXML
    private Button submitBtn;

    @FXML
    private RadioButton cvFrontRB;

    @FXML
    private RadioButton cvLeftRB;

    @FXML
    private RadioButton cvMiddleRB;

    @FXML
    private RadioButton ivLeftRB;

    @FXML
    private ToggleGroup ivFirstTOG;

    @FXML
    private Button backBtn;

    @FXML
    private RadioButton ivMiddleRB;

    @FXML
    private RadioButton cvRearRB;

    @FXML
    private RadioButton ivRightRB;

    @FXML
    private RadioButton ivFirstYesRB;

    @FXML
    void ivFirstSelect(ActionEvent event) {
        if(ivFirstYesRB.isSelected()){
            ivFirst = true;
        }
        if(ivFirstNoRB.isSelected()){
            ivFirst = false;
        }
    }

    @FXML
    void ivPOISelect(ActionEvent event) {
        if(ivFrontRB.isSelected()){
            ivPOI = 1;
        }
        if(ivMiddleRB.isSelected()){
            ivPOI = 2;
        }
        if(ivRearRB.isSelected()){
            ivPOI = 3;
        }
    }

    @FXML
    void ivActionSelect(ActionEvent event) {
        if(ivLeftRB.isSelected()){
            ivAction = 1;
        }
        if(ivStraightRB.isSelected()){
            ivAction = 2;
        }
        if(ivRightRB.isSelected()){
            ivAction = 3;
        }
    }
    
    @FXML
    void cvLocationSelect(ActionEvent event) {
        if(cvLane1RB.isSelected()){
            cvLocation = 1;
        }
        if(cvLane2RB.isSelected()){
            cvLocation = 2;
        }
        if(cvLane3RB.isSelected()){
            cvLocation = 3;
        }
    }

    @FXML
    void cvPOISelect(ActionEvent event) {
        if(cvFrontRB.isSelected()){
            cvPOI = 1;
        }
        if(cvMiddleRB.isSelected()){
            cvPOI = 2;
        }
        if(cvRearRB.isSelected()){
            cvPOI = 3;
        }
    }

    @FXML
    void cvActionSelect(ActionEvent event) {
        if(cvLeftRB.isSelected()){
            cvAction = 1;
        }
        if(cvStraightRB.isSelected()){
            cvAction = 2;
        }
        if(cvRightRB.isSelected()){
            cvAction = 3;
        }
    }

    @FXML
    void onSubmitClick(ActionEvent event) {
        
        if(ivPOI == cvPOI){
            ivPOI = 1;
            cvPOI = 1;
        }
        
        YieldLoss currentLoss = new YieldLoss(ivAction,cvAction,cvLocation,
                ivPOI,cvPOI,minLiab);
        boolean matching_loss = false;
        int insuredLiab = 0;
        int claimantLiab = 0;
        for(YieldLoss l : DataCache.yield_list){
            if((l.getIvAction() == currentLoss.getIvAction()) &&
               (l.getCvAction() == currentLoss.getCvAction()) &&
               (l.getCvLocation() == currentLoss.getCvLocation()) &&
               (l.getIvPOI() == currentLoss.getIvPOI()) &&
               (l.getCvPOI() == currentLoss.getCvPOI())){
                matching_loss = true;
                insuredLiab = l.getMinLiab();
                claimantLiab = 100 - insuredLiab;
            }
        }
        
        if(ivFirst == false && matching_loss == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Liability Decision");
            alert.setContentText("The insured is " + insuredLiab + "% liable and the claimant is " + claimantLiab + "% liable.\n" +
                                "The calculator will now be reset.");
            alert.showAndWait();
            ivAction = 1;
            cvAction = 1;
            cvLocation = 2;
            ivPOI = 1;
            cvPOI = 1;
            minLiab = 0;
            ivFirst = false;
            ivFirstNoRB.setSelected(true);
            ivLeftRB.setSelected(true);
            cvLeftRB.setSelected(true);
            cvLane2RB.setSelected(true);
            ivFrontRB.setSelected(true);
            cvFrontRB.setSelected(true);
        } else if(ivFirst == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Liability Decision");
            alert.setContentText("The insured arrived at the stop sign first and is less than 50% liable.\n"
                    + "The claimant is barred from recovery and should file a claim through the adverse carrier.\n"
                    + "The calculator will now be reset.");
            alert.showAndWait();
            ivAction = 1;
            cvAction = 1;
            cvLocation = 2;
            ivPOI = 1;
            cvPOI = 1;
            minLiab = 0;
            ivFirst = false;
            ivFirstNoRB.setSelected(true);
            ivLeftRB.setSelected(true);
            cvLeftRB.setSelected(true);
            cvLane2RB.setSelected(true);
            ivFrontRB.setSelected(true);
            cvFrontRB.setSelected(true);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Liability Decision");
            alert.setContentText("The vehicle actions selected would not result in a loss. Please update vehicle actions.\n" +
                                "The calculator will now be reset.");
            alert.showAndWait();
            ivAction = 1;
            cvAction = 1;
            cvLocation = 2;
            ivPOI = 1;
            cvPOI = 1;
            minLiab = 0;
            ivFirst = false;
            ivFirstNoRB.setSelected(true);
            ivLeftRB.setSelected(true);
            cvLeftRB.setSelected(true);
            cvLane2RB.setSelected(true);
            ivFrontRB.setSelected(true);
            cvFrontRB.setSelected(true);
        }
    }

    @FXML
    void onBackClick(ActionEvent event) throws IOException {
        
        stage = (Stage)((Button)event.getSource()).getScene().getWindow();
        SceneChange("/view/AdjusterScreen.fxml");

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
