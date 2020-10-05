package com.upgrad.eshopApp.utils;

import java.util.Date;

public class DateDifference {
    public static int differenceBetweenDates(Date initialDay , Date finalDay){
        long difference = finalDay.getTime() - initialDay.getTime();
        int daysBetween = (int) (difference / (1000*60*60*24));
        return daysBetween;
    }
}
