package com.saischool.employeepayrollapp.controller;

import com.saischool.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = { "", "/", "/get" })
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("Get Call Success "+ empId , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<String>("created Employee payroll data for: "+employeePayrollDTO, HttpStatus.OK);
    }

    @PutMapping("update/{empId}")
    public ResponseEntity<String> updateEmployeePayrollData(@Valid @PathVariable("empId") int empId,
                                                                 @RequestBody EmployeePayrollDTO employeePayrollDTO) {
        return new ResponseEntity<String>("Updated Employee payroll data for: "+employeePayrollDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        return new ResponseEntity<String>("delete call success for id: "+empId, HttpStatus.OK);
    }

}
