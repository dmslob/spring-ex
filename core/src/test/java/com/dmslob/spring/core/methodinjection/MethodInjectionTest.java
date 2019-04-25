package com.dmslob.spring.core.methodinjection;

import static org.junit.Assert.*;

import com.dmslob.spring.core.context.HelloConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloConfig.class)
public class MethodInjectionTest {

    DemoBean abstractBean;
    DemoBean standardBean;

    @Before
    public void setUp() {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
        abstractBean = (DemoBean) xmlApplicationContext.getBean("abstractLookupBean");
        standardBean = (DemoBean) xmlApplicationContext.getBean("standardLookupBean");
    }

    @Test
    public void testAbstractBeanNotEqual() {
        MyHelper helper1 = abstractBean.getMyHelper();
        MyHelper helper2 = abstractBean.getMyHelper();

        assertNotEquals(helper1, helper2);
    }

    @Test
    public void testStandartBeanNotEqual() {
        MyHelper helper1 = standardBean.getMyHelper();
        MyHelper helper2 = standardBean.getMyHelper();

        assertEquals(helper1, helper2);
    }

    @Test
    public void testTimeAbstractBean() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x < 100000; x++) {
            MyHelper helper = abstractBean.getMyHelper();
            helper.doSomeHelpful();
        }

        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }

    @Test
    public void testTimeStandardBean() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int x = 0; x < 100000; x++) {
            MyHelper helper = standardBean.getMyHelper();
            helper.doSomeHelpful();
        }

        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
