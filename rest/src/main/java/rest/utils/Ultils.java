package rest.utils;

import rest.constant.DateConstant;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ultils {

    public static LocalDateTime convertStringToLocalDateTime(String date){
        if (date == null){
            return null;
        }
        if (!date.contains(":")){
            date = date + " 00:00:00";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return dateTime;
    }
    public static String convertLocalDateTimeToString(LocalDateTime date){
        if (date == null){
            return null;
        }
        LocalDateTime dateConvert = null;

        return date.format(DateTimeFormatter.ofPattern(DateConstant.YYYY_MM_DD_HHMMSS));
    }
}
