package com.dmslob.spring.core.configuration;

import static org.junit.Assert.*;

import com.dmslob.spring.core.configuration.config.AppConfig;
import com.dmslob.spring.core.configuration.config.DataConfig;
import com.dmslob.spring.core.configuration.service.InventoryService;
import com.dmslob.spring.core.configuration.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DataConfig.class})
public class ConfigurationTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private InventoryService inventoryService;

    @Test
    public void notNullOrderService() {
        assertNotNull(orderService);
    }

    @Test
    public void notNullInventoryService() {
        assertNotNull(inventoryService);
    }
}
