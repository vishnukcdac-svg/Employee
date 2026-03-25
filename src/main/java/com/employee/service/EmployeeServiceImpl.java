package com.employee.service;

import com.employee.exceptions.BadRequestExceptions;
import com.employee.exceptions.ResourceNotFoundExceptions;
import com.employee.model.dto.EmployeeDto;
import com.employee.model.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    private  final ModelMapper modelMapper;

    // doing constructor dependency injection
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        if(employeeDto.getId() != null) {
            throw new RuntimeException("Employee already exists");
        }
        // convert dto to entity using model mapper
        Employee employeeEntity=modelMapper.map(employeeDto, Employee.class);

        Employee savedEmployee =employeeRepository.save(employeeEntity);
        // return dto saved employee
        return modelMapper.map(savedEmployee, EmployeeDto.class);

    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Employee not found with id : "+id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {

        if (id ==null  || employeeDto.getId()==null){
            throw new BadRequestExceptions("Employee id is required");
        }

        if (!Objects.equals(id,employeeDto.getId())){
            throw new BadRequestExceptions("Employee id is not matched");
        }
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Employee not found with id : "+id));

        Employee employeeEntity=modelMapper.map(employeeDto, Employee.class);
        Employee updatedEmployee =employeeRepository.save(employeeEntity);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {

        Employee employee=  employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("Employee not found with id : "+id));
        employeeRepository.delete(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        if(employees.isEmpty()){
            throw new ResourceNotFoundExceptions("No employees found");
        }
        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).toList();
    }

    @Override
    public EmployeeDto getEmployeeEmployeeCodeAndCompanyName(String employeeCode, String companyName) {

        Employee employee = employeeRepository.findByEmployeeCodeAndCompany(employeeCode, companyName)
                .orElseThrow(()->new ResourceNotFoundExceptions("Employee Not Found with employeeCode :"+employeeCode+" and companyName :"+companyName));

         EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
         return employeeDto;
    }
}
