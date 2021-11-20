package de.mkccl.flyingbarber.calender.service.impl;


import de.mkccl.flyingbarber.calender.model.EmployeeModel;
import de.mkccl.flyingbarber.calender.model.MonthModel;

import java.text.ParseException;

public interface CalenderService {


    MonthModel showCalender(int year, int day, int month) throws ParseException;
    EmployeeModel addEmployeeToCalender(EmployeeModel employeeModel);
}
