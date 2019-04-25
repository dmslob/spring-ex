package com.dmslob.spring.core.configuration.config;

import com.dmslob.spring.core.configuration.data.repository.CustomerRepository;
import com.dmslob.spring.core.configuration.data.repository.InventoryItemRepository;
import com.dmslob.spring.core.configuration.data.repository.SalesOrderRepository;
import com.dmslob.spring.core.configuration.service.InventoryService;
import com.dmslob.spring.core.configuration.service.OrderService;
import com.dmslob.spring.core.configuration.service.impl.InventoryServiceImpl;
import com.dmslob.spring.core.configuration.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@Import(DataConfig.class)
public class AppConfig {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Bean
    public OrderService orderService(InventoryService inventoryService, CustomerRepository customerRepository, SalesOrderRepository salesOrderRepository) {
        return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
    }

    @Bean
    public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
        return new InventoryServiceImpl(inventoryItemRepository);
    }
}

