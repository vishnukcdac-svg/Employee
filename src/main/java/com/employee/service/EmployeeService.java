package com.employee.service;

import com.employee.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService  {
    //save
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);
    void deleteEmployee(Long id);
    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeEmployeeCodeAndCompanyName(String employeeCode, String companyName);
}
