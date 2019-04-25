package com.dmslob.spring.core.advanced.bfpp;

import com.dmslob.spring.core.advanced.beans.NewReport;
import com.dmslob.spring.core.advanced.beans.Player;
import com.dmslob.spring.core.advanced.beans.Report;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryPostProcessorsTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorsConfiguration.class);
    }

    @Test
    public void testDeprecatedBeanFactoryPostProcessor() {
        Report report = context.getBean("oldReport", Report.class);
        report.build();

        Assert.assertEquals("DeprecatedClass was not replaced", NewReport.class, report.getClass());
    }

    @Test
    public void testWarningBeanFactoryPostProcessor() {
        Player player1 = context.getBean(Player.class);
        Player player2 = context.getBean(Player.class);

        Assert.assertNotEquals("Prototype scope should provide different instances.", player1, player2);
        context.destroy();
    }
}
