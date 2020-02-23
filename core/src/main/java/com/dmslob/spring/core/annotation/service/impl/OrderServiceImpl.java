package com.dmslob.spring.core.annotation.service.impl;

import com.dmslob.spring.core.annotation.data.repository.CustomerRepository;
import com.dmslob.spring.core.annotation.data.repository.SalesOrderRepository;
import com.dmslob.spring.core.annotation.domain.Customer;
import com.dmslob.spring.core.annotation.domain.Order;
import com.dmslob.spring.core.annotation.service.InventoryService;
import com.dmslob.spring.core.annotation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final InventoryService inventoryService;
    private final CustomerRepository customerRepository;
    private final SalesOrderRepository salesOrderRepository;

    @Autowired
    public OrderServiceImpl(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
        this.inventoryService = inventoryService;
        this.customerRepository = customerRepository;
        this.salesOrderRepository = salesOrderRepository;
    }

    public Order createOrder(Customer customer, Map<String, Long> items) {
        return null;
    }

    public Order createOrder(String customerId, Map<String, Long> items) {
        return null;
    }

    public Order getOrder(String orderId) {
        return null;
    }

    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public SalesOrderRepository getSalesOrderRepository() {
        return salesOrderRepository;
    }
}
