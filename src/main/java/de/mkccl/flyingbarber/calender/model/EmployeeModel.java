package de.mkccl.flyingbarber.calender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "calender_employee")
public class EmployeeModel {

    @Id
    @GeneratedValue
    @Column(name = "calender_employee_id")
    private int id;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeCalenderModel> date;

    @Column(name = "calender_employee_name")
    private String employeeName;

    @Column(name = "calender_employee_first_name")
    private String employeeFirstname;


}
