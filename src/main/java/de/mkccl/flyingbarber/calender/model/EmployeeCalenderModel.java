package de.mkccl.flyingbarber.calender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "calender_employee_date")
public class EmployeeCalenderModel {

    @Id
    @GeneratedValue
    @Column(name = "calender_employee_date_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "calender_employee_id", nullable = false)
    private EmployeeModel employee;

    private int day;

    private int month;

    private int year;
}
