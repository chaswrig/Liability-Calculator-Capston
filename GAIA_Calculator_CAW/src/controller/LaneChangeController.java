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
import model.LaneChangeLoss;

/**
 *
 * @author chase
 */
public class LaneChangeController implements Initializable {
    
    Stage stage;
    Parent scene;
    
    int leftAction = 1;
    int rightAction = 1;
    int leftPOI = 1;
    int rightPOI = 1;
    int leftLiab;
    int rightLiab;
    
    public void SceneChange(String string) throws IOException {
        scene = FXMLLoader.load(getClass().getResource(string));
        stage.setScene(new Scene(scene));
        stage.show();
    }
    
    @FXML
    private Button submitBtn;

    @FXML
    private RadioButton leftMoveRightRB;

    @FXML
    private RadioButton leftMiddleRB;

    @FXML
    private RadioButton rightRearRB;

    @FXML
    private RadioButton rightMoveLeftRB;

    @FXML
    private ToggleGroup leftActionTOG;

    @FXML
    private RadioButton rightFrontRB;

    @FXML
    private RadioButton rightMoveRightRB;

    @FXML
    private RadioButton leftRearRB;

    @FXML
    private ToggleGroup leftPOITOG;

    @FXML
    private RadioButton rightMoveStraightRB;

    @FXML
    private RadioButton leftMoveLeftRB;

    @FXML
    private ToggleGroup rightPOITOG;

    @FXML
    private RadioButton rightMiddleRB;

    @FXML
    private ToggleGroup rightActionTOG;

    @FXML
    private RadioButton leftMoveStraightRB;

    @FXML
    private Button backBtn;

    @FXML
    private RadioButton leftFrontRB;
    
    @FXML
    void onLPOISelect(ActionEvent event) {
        if(leftFrontRB.isSelected()){
            leftPOI = 1;
        }
        if(leftMiddleRB.isSelected()){
            leftPOI = 2;
        }
        if(leftRearRB.isSelected()){
            leftPOI = 3;
        }
    }
    
    @FXML
    void onRPOISelect(ActionEvent event) {
        if(rightFrontRB.isSelected()){
            rightPOI = 1;
        }
        if(rightMiddleRB.isSelected()){
            rightPOI = 2;
        }
        if(rightRearRB.isSelected()){
            rightPOI = 3;
        }
    }
    
    @FXML
    void onLActionSelect(ActionEvent event) {
        if(leftMoveLeftRB.isSelected()){
            leftAction = 1;
        }
        if(leftMoveStraightRB.isSelected()){
            leftAction = 2;
        }
        if(leftMoveRightRB.isSelected()){
            leftAction = 3;
        }
    }
    
    @FXML
    void onRActionSelect(ActionEvent event) {
        if(rightMoveLeftRB.isSelected()){
            rightAction = 1;
        }
        if(rightMoveStraightRB.isSelected()){
            rightAction = 2;
        }
        if(rightMoveRightRB.isSelected()){
            rightAction = 3;
        }
    }

    @FXML
    void onSubmitClick(ActionEvent event) {
        
        if(leftPOI == rightPOI){
            leftPOI = 1;
            rightPOI = 1;
        }
        
        LaneChangeLoss currentLoss = new LaneChangeLoss(leftAction,rightAction,
                leftPOI,rightPOI,leftLiab,rightLiab);
        boolean matching_loss = false;
        int leftLiabCalc = 0;
        int rightLiabCalc = 0;
        for(LaneChangeLoss l : DataCache.lane_change_list){
            if((l.getLeftAction() == currentLoss.getLeftAction()) &&
               (l.getRightAction() == currentLoss.getRightAction()) &&
               (l.getLeftPOI() == currentLoss.getLeftPOI()) &&
               (l.getRightPOI() == currentLoss.getRightPOI())){
                matching_loss = true;
                leftLiabCalc = l.getLeftLiab();
                rightLiabCalc = l.getRightLiab();
            }
        }
        
        if(matching_loss == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Liability Decision");
            alert.setContentText("The left vehicle is " + leftLiabCalc + "% liable and the right vehicle is " + rightLiabCalc + "% liable.\n" +
                                "The calculator will now be reset.");
            alert.showAndWait();
            leftFrontRB.setSelected(true);
            leftMoveLeftRB.setSelected(true);
            rightFrontRB.setSelected(true);
            rightMoveLeftRB.setSelected(true);
            leftPOI = 1;
            leftAction = 1;
            rightPOI = 1;
            rightAction = 1;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Liability Decision");
            alert.setContentText("The vehicle actions selected would not result in a loss. Please update vehicle actions.\n" +
                                "The calculator will now be reset.");
            alert.showAndWait();
            leftFrontRB.setSelected(true);
            leftMoveLeftRB.setSelected(true);
            rightFrontRB.setSelected(true);
            rightMoveLeftRB.setSelected(true);
            leftPOI = 1;
            leftAction = 1;
            rightPOI = 1;
            rightAction = 1;
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
