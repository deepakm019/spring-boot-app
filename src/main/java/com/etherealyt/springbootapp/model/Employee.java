package com.etherealyt.springbootapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @Column
    private String employeeName;
    @Column
    private String department;
    @Column
    private long salary;

    public Employee(String employeeName, String department, long salary) {
        this.employeeName = employeeName;
        this.department = department;
        this.salary = salary;
    }
}
