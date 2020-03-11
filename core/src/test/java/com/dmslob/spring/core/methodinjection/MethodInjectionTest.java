package com.dmslob.spring.core.methodinjection;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MethodInjectionConfig.class)
public class MethodInjectionTest {

    @Test
    public void whenLookupMethodCalled_thenNewInstanceReturned() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");

        StudentServices first = xmlApplicationContext.getBean(StudentServices.class);
        StudentServices second = xmlApplicationContext.getBean(StudentServices.class);

        assertEquals(first, second);
        assertNotEquals(first.getNotification(), second.getNotification());
    }
}
