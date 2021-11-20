package de.mkccl.flyingbarber.calender.repository;

import de.mkccl.flyingbarber.calender.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
}
