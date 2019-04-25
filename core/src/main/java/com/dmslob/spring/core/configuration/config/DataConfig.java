package com.dmslob.spring.core.configuration.config;

import com.dmslob.spring.core.configuration.data.repository.CustomerRepository;
import com.dmslob.spring.core.configuration.data.repository.InventoryItemRepository;
import com.dmslob.spring.core.configuration.data.repository.SalesOrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    @Bean // must not be private or final
    public InventoryItemRepository inventoryItemRepository() {
        return new InventoryItemRepository();
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepository();
    }

    @Bean
    public SalesOrderRepository salesOrderRepository() {
        return new SalesOrderRepository();
    }
}
