package com.dmslob.spring.core.annotation;

import static org.junit.Assert.*;

import com.dmslob.spring.core.annotation.config.AppConfig;
import com.dmslob.spring.core.annotation.data.repository.CustomerRepository;
import com.dmslob.spring.core.annotation.data.repository.SalesOrderRepository;
import com.dmslob.spring.core.annotation.service.InventoryService;
import com.dmslob.spring.core.annotation.service.OrderService;
import com.dmslob.spring.core.annotation.service.impl.InventoryServiceImpl;
import com.dmslob.spring.core.annotation.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void testNotNullOrderService() {
        assertNotNull(orderService);
    }

    @Test
    public void testNotNullCustomerRepository() {
        OrderServiceImpl service = (OrderServiceImpl) orderService;
        CustomerRepository customerRepository = service.getCustomerRepository();
        assertNotNull(customerRepository);
    }

    @Test
    public void testNotNullInventoryService() {
        OrderServiceImpl service = (OrderServiceImpl) orderService;
        InventoryService inventoryService = service.getInventoryService();
        assertNotNull(inventoryService);
    }

    @Test
    public void testNotNullSalesOrderRepository() {
        OrderServiceImpl service = (OrderServiceImpl) orderService;
        SalesOrderRepository salesOrderRepository = service.getSalesOrderRepository();
        assertNotNull(salesOrderRepository);
    }
}
