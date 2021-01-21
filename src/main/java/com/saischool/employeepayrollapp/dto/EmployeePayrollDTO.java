package com.saischool.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public @ToString class EmployeePayrollDTO {

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message = "Employee Name Invalid")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    @Pattern(regexp = "^(male|female)$", message = "Invalid Employee Gender")
    public String gender;

    @NotBlank(message = "ImagePath cannot be Empty")
    public String imagePath;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "start date should Not be Empty")
    @PastOrPresent(message = "start date should be past or todays date")
    public LocalDate startDate;

    @NotBlank(message = "Note cannot be Empty")
    public String notes;

    @NotBlank(message = "Department cannot be Empty")
    public List<String> departments;

    public int employeeId;
}
