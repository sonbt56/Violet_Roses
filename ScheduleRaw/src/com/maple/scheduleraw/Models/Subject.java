package com.maple.scheduleraw.Models;

import java.util.ArrayList;

public class Subject {
    
    private String name;
    private String lecturer;
    private ArrayList<Point> mPoints;

    public final static String DEFAULT_LECTURER = "someone";
    
    public Subject(String name) {
        this(name, DEFAULT_LECTURER);
    }
    public Subject(String name , String leturer) {
        this(name, leturer, new ArrayList<Point>());
    }
    
    public Subject (String name, String lecturer, ArrayList<Point > points) {
        this.name = name;
        this.lecturer = lecturer;
        this.mPoints = points;
    }
    
    public void addPont(Point aPoint) {
        mPoints.add(aPoint);
    }
        
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLecturer() {
        return lecturer;
    }
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }
    public ArrayList<Point> getmPoints() {
        return mPoints;
    }
    public void setmPoints(ArrayList<Point> mPoints) {
        this.mPoints = mPoints;
    }
    

}
