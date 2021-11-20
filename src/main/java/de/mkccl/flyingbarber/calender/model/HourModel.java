package de.mkccl.flyingbarber.calender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HourModel {

    private int minutesValue;
    private long secondsValue;
    private String hour;

}
