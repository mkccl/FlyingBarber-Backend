package de.mkccl.flyingbarber.calender.service.impl;

import de.mkccl.flyingbarber.calender.model.DayModel;
import de.mkccl.flyingbarber.calender.model.HourModel;
import de.mkccl.flyingbarber.calender.model.MonthModel;
import de.mkccl.flyingbarber.calender.utils.CalenderUtils;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CalenderServiceImpl implements CalenderService{



    @Override
    public MonthModel showCalender(int yearValue, int dayValue, int monthValue) throws ParseException {

        CalenderUtils calenderUtils = new CalenderUtils();

        /**
         *  Bekommt einen Integer. Gibt einen String zurück.
         *  Gibt den Namen des Monats anhand des Jahres und des Monats als Integer.
         */
        String month = calenderUtils.getDayOfDayValue(monthValue, dayValue);

        /**
         * Gibt die Anzahl der Tage von einem Jahr und seine Monate zurück.
         */
        int days = calenderUtils.getCurrentDaysForMonth(yearValue, dayValue);

        List<DayModel> dayModels = new ArrayList<>();

        MonthModel monthModel = new MonthModel();
        monthModel.setAmountDays(days);
        monthModel.setMonthName(month);



        for (int i = 0; i < days; i++) {
            DayModel dayModel = new DayModel();
            List<HourModel> hourModelList = new ArrayList<>();

            dayModel.setDay(i + 1);
            dayModel.setDayName(calenderUtils.getDayName(yearValue, monthValue, i + 1));

            for (int j = 1; j <= 24 ; j++) {
                HourModel hourModel = new HourModel();

                String output;

                if (j < 10) {
                    output = String.format("0%d:00", j);
                } else {
                    output = String.format("%d:00", j);
                }

                hourModel.setMinutesValue(j * 60);
                hourModel.setSecondsValue(j * 60 * 60);
                hourModel.setHour(output);
                hourModelList.add(hourModel);
            }
            dayModel.setHours(hourModelList);
            dayModels.add(dayModel);
        }




        monthModel.setDays(dayModels);

        return monthModel;


    }
}
