package de.mkccl.flyingbarber.calender.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.MonthDay;
import java.time.YearMonth;
import java.util.Date;
import java.util.Locale;


public class CalenderUtils {



    public int getCurrentDaysForMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year,month);
        System.out.println("Lenght of Days in Month: " + yearMonth.lengthOfMonth());
        return yearMonth.lengthOfMonth();
    }

    public String getDayOfDayValue(int month ,int day) {
        MonthDay monthDay = MonthDay.of(month, day);
        return monthDay.getMonth().toString();
    }

    public String getDayName(int year, int month, int day) throws ParseException {
        String dateString = String.format("%d.%d.%d", day, month, year);
        Date date = new SimpleDateFormat("d.M.yyyy").parse(dateString);

        return new SimpleDateFormat("EEEE", Locale.GERMAN).format(date);
    }


}
