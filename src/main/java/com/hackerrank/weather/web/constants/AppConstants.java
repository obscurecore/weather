package com.hackerrank.weather.web.constants;

import java.time.ZoneOffset;
import java.util.Locale;

/**
 * @author Ruslan Potapov
 */
public interface AppConstants {

    String DATE_PATTERN = "dd.MM.yyyy";
    String DATE_EXAMPLE = "dd.MM.yyyy";
    String DATE_PATTERN_YMD = "yyyy-MM-dd";
    String DATETIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    String DATETIME_EXAMPLE = "2019-07-27T08:46:27";
    String TIME_PATTERN = "HH:mm:ss";
    String TIME_EXAMPLE = "HH:mm:ss";
    String TIMEZONE = "UTC";
    String TIMEZONE_MSK = "UTC+3:00";

    String EMAIL_EXAMPLE = "some@mail.com";
    String VALID_EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";
    String VALID_PHONE_REGEX = "^\\+?[0-9]+$";

    String UUID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";

    String VALID_INSURANCE_NUMBER_REGEX = "^\\d{11}$";

    ZoneOffset MOSCOW_ZONE_OFFSET = ZoneOffset.of("+03:00");

    Locale RUSSIAN_LOCALE = Locale.forLanguageTag("ru");

    String PROMO_CODE_REGEX = "[^\\s]*";

    String QUESTIONS_FRONT_PATH = "/voprosy-i-otvety";
    String VMI_FRONT_PATH = "/dms";
    String TELEMEDICINE_FRONT_PATH = "/dms/telemeditsina";
    String MEDICAL_DOCUMENTS_FRONT_PATH = "/medicine/med-card";
}
