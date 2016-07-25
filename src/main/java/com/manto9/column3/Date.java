package com.manto9.column3;

/**
 * Created by manto9 on 01/04/16.
 */
public class Date {
    int date,mon,year;

    public Date(int date, int mon, int year) {
        this.date = date;
        this.mon = mon;
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
