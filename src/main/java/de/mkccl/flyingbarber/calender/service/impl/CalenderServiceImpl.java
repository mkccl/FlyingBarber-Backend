package de.mkccl.flyingbarber.calender.service.impl;

import de.mkccl.flyingbarber.calender.model.*;
import de.mkccl.flyingbarber.calender.repository.EmployeeRepository;
import de.mkccl.flyingbarber.calender.utils.CalenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class CalenderServiceImpl implements CalenderService{

    @Autowired
    EmployeeRepository employeeRepository;

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
        int days = calenderUtils.getCurrentDaysForMonth(yearValue, monthValue);

        List<DayModel> dayModels = new ArrayList<>();

        MonthModel monthModel = new MonthModel();
        monthModel.setAmountDays(days);
        monthModel.setMonthName(month);



        for (int i = dayValue; i <= days; i++) {
            DayModel dayModel = new DayModel();
            List<HourModel> hourModelList = new ArrayList<>();

            dayModel.setDay(i);
            dayModel.setDayName(calenderUtils.getDayName(yearValue, monthValue, i));

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

    @Override
    public EmployeeModel addEmployeeToCalender(EmployeeModel employeeModel) {

        List<EmployeeCalenderModel> employeeCalenderModel = new ArrayList<>(employeeModel.getDate());

        employeeModel.setDate(employeeCalenderModel);

        return employeeRepository.save(employeeModel);
    }
}
