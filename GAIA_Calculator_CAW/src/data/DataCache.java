/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import model.HistoricalClaim;
import model.LaneChangeLoss;
import model.YieldLoss;

/**
 *
 * @author chase
 */
public class DataCache {
    public static ArrayList<LaneChangeLoss> lane_change_list = new ArrayList<>();
    public static ArrayList<YieldLoss> yield_list = new ArrayList<>();
    public static ArrayList<HistoricalClaim> historic_list = new ArrayList<>();
    public static int yieldCount;
    public static int laneChangeCount;
    public static double totalYieldPayout;
    public static double totalLaneChangePayout;
    public static double averagePayout;
    public static int countHigherThanAverage;
    public static double largeLossPayouts;

    public static void populateLaneChangeList(LaneChangeLoss l){
        lane_change_list.add(l);
    }
    
    public static void populateYieldList(YieldLoss l){
        yield_list.add(l);
    }
    
    public static void populateHistoricList(HistoricalClaim l){
        historic_list.add(l);
    }

}
