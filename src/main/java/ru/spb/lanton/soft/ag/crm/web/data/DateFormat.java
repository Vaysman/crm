package ru.spb.lanton.soft.ag.crm.web.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateFormat {

    private static Date date = new Date();

    private DateFormat(Date date) {
        this.date = date;
    }

    /**
     * "Освежить" данные о дате.
     */
    private static void refresh() {
        date = new Date();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Получить дату в желаемом виде.
     * @param pattern патерн для возвращаемой даты.
     *                1: YYYY-MM-DD
     *                2: YYYY-DD-MM
     *                3: YY-MM-DD
     *                4: YY-DD-MM
     * @return
     */
    public static String getDate(int pattern) {
        refresh();
        String p;
        switch (pattern) {
            case 1:
                p = "yyyy-MM-dd";
                break;
            case 2:
                p = "YY-MM-dd";
                break;
            default:
                p = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(p, Locale.getDefault());
        return sdf.format(date);
    }


    private String addZero(int i) {
        return i < 10 ? "0" + Integer.toString(i) : Integer.toString(i);
    }

}
