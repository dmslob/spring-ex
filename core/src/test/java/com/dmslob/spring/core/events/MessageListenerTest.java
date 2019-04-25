package com.dmslob.spring.core.events;

import com.dmslob.spring.core.context.HelloConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloConfig.class)
public class MessageListenerTest {

    @Test
    public void testListener() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        Publisher pub = (Publisher) xmlApplicationContext.getBean("publisher");
        pub.publish("Hello World!");
        pub.publish("The quick brown fox jumped over the lazy dog");
    }
}
