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
public class HistoricalClaim {
    private int state;
    private int lossType;
    private int ivLocation;
    private int ivAction;
    private int ivPOI;
    private int cvLocation;
    private int cvAction;
    private int cvPOI;
    private int ivLiab;
    private int cvLiab;
    private double ivDamage;
    private double cvDamage;
    private double cvPayout;
    private double totalPayout;
    
    public HistoricalClaim(){
        //Default constructor override
    }
    
    public HistoricalClaim(int state, int lossType, int ivLocation, int ivAction,
            int ivPOI, int cvLocation, int cvAction, int cvPOI, int ivLiab,
            int cvLiab, double ivDamage, double cvDamage, double cvPayout,
            double totalPayout){
        this.state = state;
        this.lossType = lossType;
        this.ivLocation = ivLocation;
        this.ivAction = ivAction;
        this.ivPOI = ivPOI;
        this.cvLocation = cvLocation;
        this.cvAction = cvAction;
        this.cvPOI = cvPOI;
        this.ivLiab = ivLiab;
        this.cvLiab = cvLiab;
        this.ivDamage = ivDamage;
        this.cvDamage = cvDamage;
        this.cvPayout = cvPayout;
        this.totalPayout = totalPayout;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLossType() {
        return lossType;
    }

    public void setLossType(int lossType) {
        this.lossType = lossType;
    }

    public int getIvLocation() {
        return ivLocation;
    }

    public void setIvLocation(int ivLocation) {
        this.ivLocation = ivLocation;
    }

    public int getIvAction() {
        return ivAction;
    }

    public void setIvAction(int ivAction) {
        this.ivAction = ivAction;
    }

    public int getIvPOI() {
        return ivPOI;
    }

    public void setIvPOI(int ivPOI) {
        this.ivPOI = ivPOI;
    }

    public int getCvLocation() {
        return cvLocation;
    }

    public void setCvLocation(int cvLocation) {
        this.cvLocation = cvLocation;
    }

    public int getCvAction() {
        return cvAction;
    }

    public void setCvAction(int cvAction) {
        this.cvAction = cvAction;
    }

    public int getCvPOI() {
        return cvPOI;
    }

    public void setCvPOI(int cvPOI) {
        this.cvPOI = cvPOI;
    }

    public int getIvLiab() {
        return ivLiab;
    }

    public void setIvLiab(int ivLiab) {
        this.ivLiab = ivLiab;
    }

    public int getCvLiab() {
        return cvLiab;
    }

    public void setCvLiab(int cvLiab) {
        this.cvLiab = cvLiab;
    }

    public double getIvDamage() {
        return ivDamage;
    }

    public void setIvDamage(double ivDamage) {
        this.ivDamage = ivDamage;
    }

    public double getCvDamage() {
        return cvDamage;
    }

    public void setCvDamage(double cvDamage) {
        this.cvDamage = cvDamage;
    }

    public double getCvPayout() {
        return cvPayout;
    }

    public void setCvPayout(double cvPayout) {
        this.cvPayout = cvPayout;
    }

    public double getTotalPayout() {
        return totalPayout;
    }

    public void setTotalPayout(double totalPayout) {
        this.totalPayout = totalPayout;
    }

    @Override
    public String toString() {
        return "HistoricalClaim{" + state + " " + lossType + " " + totalPayout;
    }    
}
