package com.fedy97.springbootserver.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private Utils() {

    }

    public static String dateToyyyyMMdd(Date date) {
        return formatter.format(date);
    }

    public static Date yyyyMMddToDate(String date) throws ParseException {
        return formatter.parse(date);
    }
}
