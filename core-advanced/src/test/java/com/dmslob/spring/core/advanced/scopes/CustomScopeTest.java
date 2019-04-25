package com.dmslob.spring.core.advanced.scopes;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CustomScopeTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(CustomScopeConfiguration.class);
    }

    @Test
    public void testSharedData() {
        SharedData sharedData = context.getBean(SharedData.class);
        assertNotNull(sharedData);
    }

    @Test
    public void testSharedContextScope() {
        String userName = "test_user";
        SharedData sharedData = context.getBean(SharedData.class);
        sharedData.setUserName(userName);

        assertEquals("userName does not match.", userName, sharedData.getUserName());
    }
}
