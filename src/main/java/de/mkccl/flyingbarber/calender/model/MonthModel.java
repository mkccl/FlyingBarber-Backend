package de.mkccl.flyingbarber.calender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MonthModel {

    private String monthName;
    private int amountDays;
    private List<DayModel> days;

}
