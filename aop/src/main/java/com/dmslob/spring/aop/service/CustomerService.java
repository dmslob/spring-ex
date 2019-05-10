package com.dmslob.spring.aop.service;

import com.dmslob.spring.aop.data.entity.Customer;
import com.dmslob.spring.aop.data.repository.CustomerRepository;
import com.dmslob.spring.aop.aspect.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Loggable
    public List<Customer> getAll() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    @Loggable
    public Customer findOne(String id) {
        if (null == id) {
            throw new NullPointerException("Customer is not found");
        }
        return this.customerRepository.findOne(id);
    }
}
