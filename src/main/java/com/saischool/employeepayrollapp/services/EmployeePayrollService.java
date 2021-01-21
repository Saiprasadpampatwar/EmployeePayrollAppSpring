package com.saischool.employeepayrollapp.services;

import com.saischool.employeepayrollapp.dto.EmployeePayrollDTO;
import com.saischool.employeepayrollapp.exceptions.EmployeePayrollException;
import com.saischool.employeepayrollapp.model.EmployeePayrollData;
import com.saischool.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeePayrollRepository;


    private  List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeePayrollList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeePayrollList.stream()
                                    .filter(empData->empData.getEmployeeId()==empId)
                                    .findFirst()
                                    .orElseThrow(()-> new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData( employeePayrollDTO);
        log.debug("Emp Data: "+empData.toString());
        employeePayrollList.add(empData);

        return employeePayrollRepository.save(empData);
    }

    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        employeePayrollList.set(empId-1,empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollDTO(int empId) {
        employeePayrollList.remove(empId-1);
    }
}
