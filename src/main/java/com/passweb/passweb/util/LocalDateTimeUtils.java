package com.passweb.passweb.util;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtils {
    // 날짜와 시간을 "yyyy-MM-dd HH:mm" 형식으로 포맷하는 DateTimeFormatter입니다.
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    // 날짜를 "yyyy-MM-dd" 형식으로 포맷하는 DateTimeFormatter입니다.
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    // 날짜를 "MM-dd" 형식으로 포맷하는 DateTimeFormatter입니다.
    public static final DateTimeFormatter MM_DD = DateTimeFormatter.ofPattern("MM-dd");

    /**
     * LocalDateTime을 "yyyy-MM-dd HH:mm" 형식으로 포맷합니다.
     * @param localDateTime 포맷할 LocalDateTime 객체
     * @return 포맷된 문자열
     */
    public static String format(final LocalDateTime localDateTime) {
        return localDateTime.format(YYYY_MM_DD_HH_MM);
    }

    /**
     * LocalDateTime을 지정된 DateTimeFormatter로 포맷합니다.
     * @param localDateTime 포맷할 LocalDateTime 객체
     * @param formatter 사용할 DateTimeFormatter
     * @return 포맷된 문자열
     */
    public static String format(final LocalDateTime localDateTime, DateTimeFormatter formatter) {
        return localDateTime.format(formatter);
    }

    /**
     * 문자열을 "yyyy-MM-dd HH:mm" 형식으로 파싱하여 LocalDateTime 객체로 변환합니다.
     * @param localDateTimeString 파싱할 문자열
     * @return 파싱된 LocalDateTime 객체
     */
    public static LocalDateTime parse(final String localDateTimeString) {
        if (StringUtils.isBlank(localDateTimeString)) {
            return null;
        }
        return LocalDateTime.parse(localDateTimeString, YYYY_MM_DD_HH_MM);
    }

    /**
     * 문자열을 "yyyy-MM-dd" 형식으로 파싱하여 LocalDateTime 객체로 변환합니다.
     * @param localDateTimeString 파싱할 문자열
     * @return 파싱된 LocalDateTime 객체 (시간은 00:00:00)
     */
    public static LocalDateTime parseDate(final String localDateTimeString) {
        if (StringUtils.isBlank(localDateTimeString)) {
            return null;
        }
        return LocalDate.parse(localDateTimeString, YYYY_MM_DD).atStartOfDay();
    }
}
