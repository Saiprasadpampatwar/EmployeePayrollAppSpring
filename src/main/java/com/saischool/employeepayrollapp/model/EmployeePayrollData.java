package com.saischool.employeepayrollapp.model;

import com.saischool.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String name;
    private long salary;
    public String gender;
    public String imagePath;
    public LocalDate startDate;
    public String notes;

    @ElementCollection
    @CollectionTable(name = "employee_department",joinColumns = @JoinColumn (name = "id"))
    @Column(name = "department")
    public List<String> departments;


    public EmployeePayrollData() { }

    public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.imagePath= employeePayrollDTO.imagePath;
        this.gender = employeePayrollDTO.gender;
        this.startDate=employeePayrollDTO.startDate;
        this.departments = employeePayrollDTO.departments;
        this.notes = employeePayrollDTO.notes;
    }

}
