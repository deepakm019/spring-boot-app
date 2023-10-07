package com.etherealyt.springbootapp.repository;

import com.etherealyt.springbootapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
