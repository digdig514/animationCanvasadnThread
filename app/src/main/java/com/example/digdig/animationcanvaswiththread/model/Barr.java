package com.example.digdig.animationcanvaswiththread.model;

/**
 * Created by digdig on 17-06-14.
 */

import android.graphics.Bitmap;

public class Barr {
    private float width;
    private float height;
    private Bitmap image;
    private  float xdirection;
    private boolean position;

    public Barr(Bitmap image) {

        this.image = image;

    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public float getXdirection() {
        return xdirection;
    }

    public void setXdirection(float xdirection) {
        this.xdirection = xdirection;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }

    public Barr(Bitmap bitmap, float width, float height) {

        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getCenter() {
        return getWidth()/2;
    }

}
