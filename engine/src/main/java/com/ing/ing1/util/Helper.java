package com.ing.ing1.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ggkekas on 20/11/15.
 */
public class Helper {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat MONTH_FORMAT = new SimpleDateFormat("yyyy-MM");

    public static int getMonthsDifference(Calendar startCalendar, Calendar endCalendar) {
        int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
        return diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
    }

    public static Calendar getEpochStart() {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(MONTH_FORMAT.parse("2000-01"));
        } catch (ParseException e) {
        }
        return calendar;
    }

    public static Calendar getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static String getMonthString(Calendar date) {
        return MONTH_FORMAT.format(date.getTime());
    }

    public static String getDateString(Calendar date) {
        return DATE_FORMAT.format(date.getTime());
    }

    public static Calendar getCalendarFromStringDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE_FORMAT.parse(date));
        return calendar;
    }

    public static int getMonthsDifferenceFromNow(Calendar goalStart) {
        Calendar currCalendar = Calendar.getInstance();
        return getMonthsDifference(goalStart, currCalendar);
    }
}
