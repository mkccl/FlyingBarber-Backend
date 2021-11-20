package de.mkccl.flyingbarber.calender.controller;

import de.mkccl.flyingbarber.calender.model.EmployeeModel;
import de.mkccl.flyingbarber.calender.model.MonthModel;
import de.mkccl.flyingbarber.calender.service.impl.CalenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("api/v1/calender")
public class CalenderController {

    @Autowired
    CalenderServiceImpl calenderService;


    @PostMapping
    public MonthModel getCalender(int year, int month, int day) throws ParseException {
        return calenderService.showCalender(year, day, month);
    }

    @PostMapping("/add/employee")
    public EmployeeModel addEmployeeToCalender(@RequestBody EmployeeModel employeeModel) {
        return calenderService.addEmployeeToCalender(employeeModel);
    }

}
