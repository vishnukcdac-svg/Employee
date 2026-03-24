package com.employee.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String employeeName;
    private  String company;
    private  String employeeCode;
    private  String email;




    public Employee( ) {

    }

    public Employee(Long id, String employeeName, String company, String employeeCode, String email) {
        this.id = id;
        this.employeeName = employeeName;
        this.company = company;
        this.employeeCode = employeeCode;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", company='" + company + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
