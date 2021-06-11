/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chase
 */
public class YieldLoss {
    private int ivAction;
    private int cvAction;
    private int cvLocation;
    private int ivPOI;
    private int cvPOI;
    private int minLiab;
    
    public YieldLoss(){
        //Default constructor override
    }
    
    public YieldLoss(int ivAction, int cvAction, int cvLocation, int ivPOI,
            int cvPOI, int minLiab){
        this.ivAction = ivAction;
        this.cvAction = cvAction;
        this.cvLocation = cvLocation;
        this.ivPOI = ivPOI;
        this.cvPOI = cvPOI;
        this.minLiab = minLiab;
    }

    public int getIvAction() {
        return ivAction;
    }

    public void setIvAction(int ivAction) {
        this.ivAction = ivAction;
    }

    public int getCvAction() {
        return cvAction;
    }

    public void setCvAction(int cvAction) {
        this.cvAction = cvAction;
    }

    public int getCvLocation() {
        return cvLocation;
    }

    public void setCvLocation(int cvLocation) {
        this.cvLocation = cvLocation;
    }

    public int getIvPOI() {
        return ivPOI;
    }

    public void setIvPOI(int ivPOI) {
        this.ivPOI = ivPOI;
    }

    public int getCvPOI() {
        return cvPOI;
    }

    public void setCvPOI(int cvPOI) {
        this.cvPOI = cvPOI;
    }

    public int getMinLiab() {
        return minLiab;
    }

    public void setMinLiab(int minLiab) {
        this.minLiab = minLiab;
    }

    @Override
    public String toString() {
        return "Yield Loss(IV action = " + ivAction + ", CV action = " + cvAction
                + ", CV Location = " + cvLocation + " IV POI = " + ivPOI
                + ", CV POI = " + cvPOI + ", Min Liab = " + minLiab + "}";
    }
    
    
}
