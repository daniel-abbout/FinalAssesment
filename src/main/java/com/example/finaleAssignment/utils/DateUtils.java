package com.example.finaleAssignment.utils;


import java.util.Date;

public class DateUtils {

    private DateUtils() {

    }

    public static boolean isDateBeforeOrEqual(Date date1, Date date2) {
        return date1.before(date2) || date1.equals(date2);
    }

    public static boolean isDateAfterOrEqual(Date date1, Date date2) {
        return date1.after(date2) || date1.equals(date2);
    }
}
