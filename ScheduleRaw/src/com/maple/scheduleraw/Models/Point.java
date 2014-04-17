package com.maple.scheduleraw.Models;

public class Point {
    
    private int point;
    private int multiplier;
    
    public final static int MAX_POINT = 10;
    public final static int MIN_POINT = 0;
    public final static int DEFAULT_MULTIPLIER = 1;
    
    public Point (int point) {
        this(point, DEFAULT_MULTIPLIER);
    }
    
    public Point(int point , int multipler) {
        this.point = point;
        this.multiplier = multipler;
    }
    
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public int getMultiplier() {
        return multiplier;
    }
    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
    
}
