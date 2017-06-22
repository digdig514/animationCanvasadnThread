package com.example.digdig.animationcanvaswiththread.model;

import android.graphics.Bitmap;

/**
 * Created by digdig on 17-05-24.
 */

public class Coconut {
    private float xPos;
    private float yPos;
    private float setxDirection;
    private float setyDirection;
    private int speed=1;
    private Bitmap bitmap;
    private boolean initialposition=false;
    private boolean bumpbarr=false;
    private boolean setAllCoconuts=false;
    private boolean stopcoconuts=false;

    public boolean isStopcoconuts() {
        return stopcoconuts;
    }

    public void setStopcoconuts(boolean stopcoconuts) {
        this.stopcoconuts = stopcoconuts;
    }

    public void setyPos(float yPos) {
        this.yPos = yPos;
    }

    public boolean isSetAllCoconuts() {
        return setAllCoconuts;
    }

    public void setSetAllCoconuts(boolean setAllCoconuts) {
        this.setAllCoconuts = setAllCoconuts;
    }

    public boolean isBumpbarr() {
        return bumpbarr;
    }

    public void setBumpbarr(boolean bumpbarr) {
        this.bumpbarr = bumpbarr;
    }



    public boolean isInitialposition() {
        return initialposition;
    }

    public void setInitialposition(boolean initialposition) {
        this.initialposition = initialposition;
    }






    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    public float getSetxDirection() {
        return setxDirection;
    }

    public void setSetxDirection(float setxDirection) {
        this.setxDirection = setxDirection;
    }

    public float getSetyDirection() {
        return setyDirection;
    }

    public void setSetyDirection(float setyDirection) {
        this.setyDirection = setyDirection;
    }

    //private Bitmap bitmap;

    public Coconut(float xPos, float yPos, Bitmap bitmap, float setxDirection, float setyDirection, int speed) {
        this.bitmap=bitmap;
        this.xPos = xPos;
        this.yPos = yPos;
        this.setxDirection =setxDirection;
        this.setyDirection = setyDirection;
        this.speed = speed;
    }
    public Coconut(float xPos, float yPos, Bitmap bitmap) {

        this.xPos = xPos;
        this.yPos = yPos;
        this.bitmap=bitmap;

;
    }

    public float getxPos() {
        return xPos;
    }

    public void setxPos(float xPos) {
        this.xPos = xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return "X position: "+xPos+"Y position: "+yPos;
    }
}
