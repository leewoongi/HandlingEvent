package com.prography.myapplication.mvc.model;

public class MvcViewXY {
    private float viewX;
    private float viewY;

    public MvcViewXY(float viewX, float viewY) {
        this.viewX = viewX;
        this.viewY = viewY;
    }

    public MvcViewXY() {

    }

    public float getViewX() {
        return viewX;
    }

    public void setViewX(float viewX) {
        this.viewX = viewX;
    }

    public float getViewY() {
        return viewY;
    }

    public void setViewY(float viewY) {
        this.viewY = viewY;
    }

    public void updateXY(float viewX, float viewY){
        this.viewX = viewX;
        this.viewY = viewY;
    }
}
