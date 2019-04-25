package com.dmslob.spring.core.advanced.quoters;

import com.dmslob.spring.core.advanced.context.PropertyFileApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Destroy method doesn't work for prototype beans
public class Main {

    private static final String CONTEXT_XML = "context.xml";
    private static final String CONTEXT_PROPERTIES = "context.properties";

    public static void main(String[] args) throws InterruptedException {
        //runForPropertyContext();
        runForMBeanServer();
    }

    private static void runForMBeanServer() throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_XML);
        context.getBean(TerminatorQuoter.class).sayQuote();

//        while (true) {
//            Thread.sleep(100);
//            context.getBean(Quoter.class).sayQuote();
//        }
    }

    public static void run() {
        new ClassPathXmlApplicationContext(CONTEXT_XML);
    }

    private static void runForPropertyContext() {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext(CONTEXT_PROPERTIES);
        context.getBean(Quoter.class).sayQuote();
    }
}
