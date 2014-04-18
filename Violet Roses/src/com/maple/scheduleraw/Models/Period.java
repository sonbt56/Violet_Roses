package com.maple.scheduleraw.Models;

public class Period {

    private Subject            mSubject;
    private String             lecturer;
    private String             place;

    public final static String DEFAULT_PLACE    = "My class";

    public Period(Subject subject) {
        this(subject, subject.getLecturer());
    }

    public Period(Subject subject, String lecturer) {
        this(subject, lecturer, DEFAULT_PLACE);
    }

    public Period(Subject subject, String lecturer, String place) {
        this.mSubject = subject;
        this.lecturer = lecturer;
        this.place = place;
    }

    public Subject getmSubject() {
        return mSubject;
    }

    public void setmSubject(Subject mSubject) {
        this.mSubject = mSubject;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
