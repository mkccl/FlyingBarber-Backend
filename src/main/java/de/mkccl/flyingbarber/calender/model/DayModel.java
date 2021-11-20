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

public class DayModel {

   private int day;
   private String dayName;
   List<HourModel> hours;

}
