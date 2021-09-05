package com.hackerrank.weather.utils;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public interface DateTimeFormats {
    SimpleDateFormat dateFormatYMDViaHyphen = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat timeFormatHMSViaColon = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat dateFormatDMYViaDot = new SimpleDateFormat("dd.MM.yyyy");

    DateTimeFormatter vkLocalDateFormatDMYViaDot = DateTimeFormatter.ofPattern("d.M.yyyy");
    DateTimeFormatter localDateFormatDMYViaDot = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    DateTimeFormatter localTimeFormatHMViaColon = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter localDateFormatYMDViaHyphen = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter localDateTimeTFormatMDYHMSA = DateTimeFormatter.ofPattern("MMM d yyyy hh:mm:ss:SSSa");
}