package com.dmslob.spring.core.context;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloConfig.class)
public class SpringContextTest {

    @Autowired
    private Person person;

    @Autowired
    private Walker walker;

    @Test
    public void notNullPerson() {
        assertNotNull(person);
    }

    @Test
    public void notNullNameOfPerson() {
        System.out.println(person.getName());
        assertNotNull(person.getName());
    }

    @Test
    public void testMessageRenderer() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        MessageRenderer messageRenderer = (MessageRenderer) context.getBean("MessageRenderer");

        assertEquals(messageRenderer.message(), "Message");
    }

    @Test
    public void testIsMessageRendererSingleton() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        MessageRenderer messageRendererOne = (MessageRenderer) context.getBean("MessageRenderer");
        MessageRenderer messageRendererTwo = (MessageRenderer) context.getBean("MessageRenderer");

        boolean isSingleton = (messageRendererTwo == messageRendererOne);
        System.out.println("isSingleton: " + isSingleton);
        assertTrue(isSingleton);
    }

    @Test
    public void testIsMessageRendererSingletonForAC() {
        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring-beans.xml");
        ApplicationContext context2 = new ClassPathXmlApplicationContext("spring-beans.xml");

        MessageRenderer messageRendererOne = (MessageRenderer) context1.getBean("MessageRenderer");
        MessageRenderer messageRendererTwo = (MessageRenderer) context2.getBean("MessageRenderer");

        boolean isSingleton = (messageRendererOne == messageRendererTwo);
        System.out.println(isSingleton);
        assertTrue(isSingleton);
    }

    @Test
    public void notNullPersonFromXml() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        Person person = (Person) context.getBean("person");
        assertNotNull(person);
    }

    @Test
    public void testWalker() {
        //ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        assertNotNull(walker);
    }

    @Test
    public void createEventXmlContext() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Event eventOne = (Event) xmlApplicationContext.getBean("Event");
        assertNotNull(eventOne);
    }

    @Test
    public void eventScopeTest() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Event eventOne = (Event) xmlApplicationContext.getBean("Event");
        Event eventTwo = (Event) xmlApplicationContext.getBean("Event");
        assertNotEquals(eventOne, eventTwo);
    }
}
