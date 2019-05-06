package com.dmslob.spring.aop.basic;

import com.dmslob.spring.aop.basic.service.EmployeeService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeService employeeService = ctx.getBean("employeeService", EmployeeService.class);
        System.out.println(employeeService.getEmployee().getName());

        employeeService.getEmployee().setName("Dmytro");

        //employeeService.getEmployee().throwException();

        ctx.close();
    }
}
