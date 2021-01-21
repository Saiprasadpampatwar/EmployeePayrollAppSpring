package com.saischool.employeepayrollapp.services;

import com.saischool.employeepayrollapp.dto.EmployeePayrollDTO;
import com.saischool.employeepayrollapp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {

    List<EmployeePayrollData> getEmployeePayrollData();

    EmployeePayrollData getEmployeePayrollDataById(int empId);

    EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO);

    EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO);

    void deleteEmployeePayrollDTO(int empId);

    List<EmployeePayrollData> getEmployeesByDepartment(String department);
}
