package com.dmslob.spring.core.annotation;

import static org.junit.Assert.*;

import com.dmslob.spring.core.annotation.config.AppConfig;
import com.dmslob.spring.core.annotation.service.OrderService;
import com.dmslob.spring.core.annotation.service.impl.InventoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AnnotationTest {

    @Autowired
    private InventoryServiceImpl inventoryService;

    @Autowired
    private OrderService orderService;

    @Test
    public void notNullOrderService() {
        assertNotNull(orderService);
    }

    @Test
    public void testAutowired() {
        inventoryService.find(5);
    }
}
