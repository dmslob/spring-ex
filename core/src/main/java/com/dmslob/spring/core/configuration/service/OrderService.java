package com.dmslob.spring.core.configuration.service;

import com.dmslob.spring.core.configuration.domain.Customer;
import com.dmslob.spring.core.configuration.domain.Order;

import java.util.Map;

public interface OrderService {

    Order createOrder(Customer customer, Map<String, Long> items);

    Order createOrder(String customerId, Map<String, Long> items);

    Order getOrder(String orderId);
}
