package com.employee.controller;

import com.employee.exceptions.BadRequestExceptions;
import com.employee.exceptions.MissingParameterException;
import com.employee.model.dto.EmployeeDto;
import com.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/save-employee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable (name = "id") Long id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully",HttpStatus.NO_CONTENT);
    }

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @GetMapping("/employee/by-code-and-company")
    public ResponseEntity<EmployeeDto> getEmployeeEmployeeCodeAndCompanyName(@RequestParam(name="employeeCode",required = false) String employeeCode
            ,@RequestParam(name="companyName",required = false) String companyName) {

        List<String> missingParameters = new ArrayList<>();
        if(employeeCode == null || employeeCode.trim().isEmpty()) {
           missingParameters.add("employeeCode");
        }

        if(companyName == null || companyName.trim().isEmpty()) {
            missingParameters.add("companyName");
        }

        if(!missingParameters.isEmpty()) {
          //  throw new MissingParameterException("Missing parameters", String.join(", ", missingParameters));

            String finalMassage=missingParameters.stream().collect(Collectors.joining(","));
            throw new MissingParameterException("Please provide "+finalMassage);
        }
       EmployeeDto employeeDto = employeeService.getEmployeeEmployeeCodeAndCompanyName(employeeCode,companyName);
       return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
}
