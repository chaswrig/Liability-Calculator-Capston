/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaia_calculator_caw;

import static data.DataCache.totalYieldPayout;
import static data.DataCache.averagePayout;
import static data.DataCache.countHigherThanAverage;
import static data.DataCache.laneChangeCount;
import static data.DataCache.largeLossPayouts;
import static data.DataCache.totalLaneChangePayout;
import static data.DataCache.yieldCount;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.HistoricalClaim;
import model.LaneChangeLoss;
import model.YieldLoss;

/**
 *
 * @author chase
 */
public class GAIA_Calculator_CAW extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/LaunchScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //import lane change data
        String path = "src/data/lane_change_data.csv";
        String line = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            
            while((line = br.readLine()) != null){
                String[] lane_change_data = line.split(",");
                if(!lane_change_data[1].equals("Left Vehicle Action")){
                    //creates new losses and adds them to the list for calculator
                    LaneChangeLoss example = new LaneChangeLoss(Integer.parseInt(lane_change_data[1]), Integer.parseInt(lane_change_data[2]), Integer.parseInt(lane_change_data[3]), Integer.parseInt(lane_change_data[4]), Integer.parseInt(lane_change_data[5]), Integer.parseInt(lane_change_data[6]));
                    data.DataCache.populateLaneChangeList(example);
                }
            }         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GAIA_Calculator_CAW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GAIA_Calculator_CAW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //import yield data
        String path2 = "src/data/yield_data.csv";
        String line2 = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path2));
            
            while((line = br.readLine()) != null){
                String[] yield_data = line.split(",");
                if(!yield_data[1].equals("IV Action")){
                    //creates new losses and adds them to the list for calculator
                    YieldLoss example = new YieldLoss(Integer.parseInt(yield_data[1]), Integer.parseInt(yield_data[2]), Integer.parseInt(yield_data[3]), Integer.parseInt(yield_data[4]), Integer.parseInt(yield_data[5]),Integer.parseInt(yield_data[6]));
                    data.DataCache.yield_list.add(example);
                }
            }
        }   catch (FileNotFoundException ex) {
            Logger.getLogger(GAIA_Calculator_CAW.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
            Logger.getLogger(GAIA_Calculator_CAW.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        //import historic claim data
        String path3 = "src/data/claim_data.csv";
        String line3 = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path3));
            
            while((line=br.readLine()) != null){
                String[] claim_data = line.split(",");
                if(!claim_data[1].equals("State")){
                    HistoricalClaim example = new HistoricalClaim(Integer.parseInt(claim_data[1]),Integer.parseInt(claim_data[2]),Integer.parseInt(claim_data[3]),Integer.parseInt(claim_data[4]),Integer.parseInt(claim_data[5]),Integer.parseInt(claim_data[6]),Integer.parseInt(claim_data[7]),
                    Integer.parseInt(claim_data[8]),Integer.parseInt(claim_data[9]),Integer.parseInt(claim_data[10]),Double.parseDouble(claim_data[11]),Double.parseDouble(claim_data[12]),Double.parseDouble(claim_data[13]),Double.parseDouble(claim_data[14]));
                    data.DataCache.historic_list.add(example);
                    if(example.getLossType() == 1){
                        yieldCount = yieldCount + 1;
                        totalYieldPayout = totalYieldPayout + example.getTotalPayout();
                        averagePayout = (totalYieldPayout + totalLaneChangePayout)/(yieldCount + laneChangeCount);
                        if(example.getTotalPayout() > averagePayout){
                            countHigherThanAverage++;
                            largeLossPayouts = largeLossPayouts + example.getTotalPayout();
                        }
                    } else if(example.getLossType() == 2){
                        laneChangeCount = laneChangeCount +1;
                        totalLaneChangePayout = totalLaneChangePayout + example.getTotalPayout();
                        averagePayout = (totalYieldPayout + totalLaneChangePayout)/(yieldCount + laneChangeCount);
                        if(example.getTotalPayout() > averagePayout){
                            countHigherThanAverage++;
                            largeLossPayouts = largeLossPayouts + example.getTotalPayout();
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GAIA_Calculator_CAW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GAIA_Calculator_CAW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//    //test counts
//    System.out.println("Yield count = " + yieldCount);
//    System.out.println("Lane Change count = " + laneChangeCount);
//    System.out.println("Total yield payout = " + totalYieldPayout);
//    System.out.println("Total lane change payout = " + totalLaneChangePayout);
//    System.out.println("Average payout = " + averagePayout);
//    System.out.println("Higher than average count = " + countHigherThanAverage);
//    System.out.println("Large Loss Payout = " + largeLossPayouts);
            
    launch(args);      
    }
}
