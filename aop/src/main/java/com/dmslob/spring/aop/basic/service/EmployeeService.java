package com.dmslob.spring.aop.basic.service;

import com.dmslob.spring.aop.basic.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

    private Employee employee;

    public EmployeeService() {
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee e) {
        this.employee = e;
    }
}
