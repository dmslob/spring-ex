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

    @Autowired
    MessageRenderer messageRenderer;

    @Autowired
    MessageRenderer messageRenderer2;

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
        assertEquals(messageRenderer.message(), "Message");
    }

    @Test
    public void testIsMessageRendererSingleton() {
        boolean isSingleton = (messageRenderer == messageRenderer2);
        System.out.println("isSingleton: " + isSingleton);
        assertTrue(isSingleton);
    }

    @Test
    public void notNullPersonFromXml() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        Person person = (Person) context.getBean("person");
        assertNotNull(person);
    }

    @Test
    public void testGreeting() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);
        String greeting = (String) context.getBean("greeting");
        System.out.println(greeting);
        assertNotNull(greeting);
        assertEquals("Hello", greeting);
    }

    @Test
    public void testWalker() {
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
        System.out.println(eventOne == eventTwo);
        assertNotEquals(eventOne, eventTwo);
    }
}
