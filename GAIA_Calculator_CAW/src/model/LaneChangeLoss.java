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
public class LaneChangeLoss {
    private int leftAction;
    private int rightAction;
    private int leftPOI;
    private int rightPOI;
    private int leftLiab;
    private int rightLiab;
    
    public LaneChangeLoss(){
    //Default constructor override
    }
    
    public LaneChangeLoss(int leftAction, int rightAction, int leftPOI, 
            int rightPOI, int leftLiab, int rightLiab){
        this.leftAction = leftAction;
        this.rightAction = rightAction;
        this.leftPOI = leftPOI;
        this.rightPOI = rightPOI;
        this.leftLiab = leftLiab;
        this.rightLiab = rightLiab;
    }

    public int getLeftAction() {
        return leftAction;
    }

    public void setLeftAction(int leftAction) {
        this.leftAction = leftAction;
    }

    public int getRightAction() {
        return rightAction;
    }

    public void setRightAction(int rightAction) {
        this.rightAction = rightAction;
    }

    public int getLeftPOI() {
        return leftPOI;
    }

    public void setLeftPOI(int leftPOI) {
        this.leftPOI = leftPOI;
    }

    public int getRightPOI() {
        return rightPOI;
    }

    public void setRightPOI(int rightPOI) {
        this.rightPOI = rightPOI;
    }

    public int getLeftLiab() {
        return leftLiab;
    }

    public void setLeftLiab(int leftLiab) {
        this.leftLiab = leftLiab;
    }

    public int getRightLiab() {
        return rightLiab;
    }

    public void setRightLiab(int rightLiab) {
        this.rightLiab = rightLiab;
    }

    @Override
    public String toString() {
        return "LaneChangeLoss{Left Action = " + leftAction + 
               ", Right Aciton = " + rightAction + ", Left POI = " + leftPOI +
               ", Right POI = " + rightPOI + ", Left Liab = " + leftLiab + 
               ", Right Liab = " + rightLiab + "}";
    }
}
