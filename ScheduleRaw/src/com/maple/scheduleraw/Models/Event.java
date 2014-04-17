package com.maple.scheduleraw.Models;

public class Event {

    private Subject         mSubject;
    private int             type;
    private String          place;
    private String          note;

    public final static int TYPE_QUICK_EXAM = 0;
    public final static int TYPE_EXAM       = 1;
    public final static int TYPE_PRACTICE   = 2;
    public final static int TYPE_HOMEWORK   = 3;
    public final static int TYPE_OTHER      = 4;
    
    public final static String DEFAULT_NOTE = "";

    public Event() {
        this(null,TYPE_OTHER, Period.DEFAULT_PLACE,DEFAULT_NOTE);
    }
    
    public Event(String note) {
        this(null,TYPE_OTHER, Period.DEFAULT_PLACE,note);
    }
    
    public Event(Subject subject, int type, String place, String note) {
        this.mSubject =subject;
        this.type = type;
        this.place = place;
        this.note = note;
    }
    
    
    public Subject getmSubject() {
        return mSubject;
    }
    public void setmSubject(Subject mSubject) {
        this.mSubject = mSubject;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
    
}
