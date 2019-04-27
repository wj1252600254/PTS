package utils;


import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static Date string2Date(String time) {
        Date date = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            System.out.println("Please input right format of time(e.g 1970-1-1)");
            e.printStackTrace();
        }
        return date;
    }




}
