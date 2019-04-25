package com.dmslob.spring.core.configuration.service.impl;

import com.dmslob.spring.core.configuration.data.repository.CustomerRepository;
import com.dmslob.spring.core.configuration.data.repository.SalesOrderRepository;
import com.dmslob.spring.core.configuration.domain.Customer;
import com.dmslob.spring.core.configuration.domain.Order;
import com.dmslob.spring.core.configuration.service.InventoryService;
import com.dmslob.spring.core.configuration.service.OrderService;

import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private final InventoryService inventoryService;
    private final CustomerRepository customerRepository;
    private final SalesOrderRepository salesOrderRepository;

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
}
