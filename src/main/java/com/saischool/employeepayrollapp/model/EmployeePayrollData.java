package com.saischool.employeepayrollapp.model;

import com.saischool.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollData {

    private int employeeId;
    private String name;
    private long salary;
    public String gender;
    public String imagePath;
    public LocalDate startDate;
    public String notes;
    public List<String> departments;


    public EmployeePayrollData() { }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
        this.imagePath= employeePayrollDTO.imagePath;
        this.gender = employeePayrollDTO.gender;
        this.startDate=employeePayrollDTO.startDate;
        this.departments = employeePayrollDTO.departments;
        this.notes = employeePayrollDTO.notes;
    }

}
