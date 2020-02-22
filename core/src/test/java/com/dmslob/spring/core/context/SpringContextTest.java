package com.dmslob.spring.core.context;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ContextConfig.class)
public class SpringContextTest {

    @Autowired
    private Person person;

    @Autowired
    private Walker walker;

    @Autowired
    MessageRenderer messageRenderer;

    @Autowired
    MessageRenderer messageRenderer2;

    @BeforeClass
    public static void setUp() {
        System.out.println("setUp()");
    }

    @Test
    public void testNotNullPerson() {
        assertNotNull(person);
    }

    @Test
    public void testNotNullNameOfPerson() {
        assertNotNull(person.getName());
    }

    @Test
    public void testMessage() {
        assertEquals(messageRenderer.message(), "Message");
    }

    @Test
    public void testIsMessageRendererSingleton() {
        boolean isSingleton = (messageRenderer == messageRenderer2);
        assertTrue(isSingleton);
    }

    @Test
    public void testNotNullPersonFromXml() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        Person person = (Person) context.getBean("person");
        assertNotNull(person);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testNoSuchBeanDefinitionException() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
        context.getBean("greetingService");
    }

    @Test
    public void testNotNullWalker() {
        assertNotNull(walker);
    }

    @Test
    public void testXmlContext() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Event eventOne = (Event) xmlApplicationContext.getBean("Event");

        assertNotNull(eventOne);
    }

    @Test
    public void testBeanWithPrototypeScope() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Event eventOne = (Event) xmlApplicationContext.getBean("Event");
        Event eventTwo = (Event) xmlApplicationContext.getBean("Event");

        assertNotEquals(eventOne, eventTwo);
    }
}
