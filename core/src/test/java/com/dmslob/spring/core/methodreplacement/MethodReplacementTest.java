package com.dmslob.spring.core.methodreplacement;

import static org.junit.Assert.*;

import com.dmslob.spring.core.context.HelloConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloConfig.class)
public class MethodReplacementTest {

    @Test
    public void testNewCar() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Car car = (Car) xmlApplicationContext.getBean("car");
        String breakText = car.breaks();
        System.out.println("breakText = " + breakText);

        assertEquals("New car break.", breakText);
    }
}
