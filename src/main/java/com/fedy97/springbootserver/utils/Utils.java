package com.fedy97.springbootserver.utils;

import lombok.extern.slf4j.Slf4j;
import org.openapitools.jackson.nullable.JsonNullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

@Slf4j
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

    public static <T> void changeIfPresent(JsonNullable<T> nullable, Consumer<T> consumer) {
        try {
            if (nullable != null && nullable.isPresent()) {
                consumer.accept(nullable.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
