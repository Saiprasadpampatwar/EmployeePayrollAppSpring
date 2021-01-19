package com.saischool.employeepayrollapp.controller;

import com.saischool.employeepayrollapp.dto.EmployeePayrollDTO;
import com.saischool.employeepayrollapp.dto.ResponseDTO;
import com.saischool.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        ResponseDTO respDTO = new ResponseDTO("Get Call SuccessFul",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        ResponseDTO respDTO = new ResponseDTO("Get Call for ID SuccessFul",empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data SuccessFul",empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @PutMapping("update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data SuccessFul",empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted Successfully"," deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

}
