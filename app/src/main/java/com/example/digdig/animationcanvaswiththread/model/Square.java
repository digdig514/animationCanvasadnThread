package com.example.digdig.animationcanvaswiththread.model;

import android.graphics.Bitmap;

/**
 * Created by digdig on 17-05-24.
 */

public class Square {
    private float xPos;
    private float yPos;
    private Bitmap bitmap;

    public Square(float xPos, float yPos, Bitmap bitmap) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.bitmap = bitmap;
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

    public void setyPos(float yPos) {
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
