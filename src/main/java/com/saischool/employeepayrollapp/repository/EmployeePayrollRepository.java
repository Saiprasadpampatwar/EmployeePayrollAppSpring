package com.saischool.employeepayrollapp.repository;

import com.saischool.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData,Integer> {
}
