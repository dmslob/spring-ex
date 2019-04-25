package com.dmslob.spring.core.annotation.service;

import com.dmslob.spring.core.annotation.domain.Customer;
import com.dmslob.spring.core.annotation.domain.Order;

import java.util.Map;

public interface OrderService {

    Order createOrder(Customer customer, Map<String, Long> items);

    Order createOrder(String customerId, Map<String, Long> items);

    Order getOrder(String orderId);
}
