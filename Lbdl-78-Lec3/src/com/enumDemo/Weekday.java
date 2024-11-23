package com.enumDemo;

//constants in java
public enum Weekday  {

    SUNDAY(0,"sun"),
    MONDAY(1,"mon"),
    TUESDAY(2,"tues");

    public int getDayIndex() {
        return dayIndex;
    }


    public void setDayIndex(int dayIndex) {
        this.dayIndex = dayIndex;
    }

    public String getShortForm() {
        return shortForm;
    }

    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

    private int dayIndex;
    private String shortForm;
    private EnumClass enumClass;

    Weekday(int dayIndex,String shortForm){
        this.dayIndex = dayIndex;
        this.shortForm = shortForm;
    }

    @Override
    public String toString() {
        return "Weekday{" +
                "dayIndex=" + dayIndex +
                ", shortForm='" + shortForm + '\'' +
                ", enumClass=" + enumClass +
                '}';
    }

    //    Weekday(){
//
//    }


}
