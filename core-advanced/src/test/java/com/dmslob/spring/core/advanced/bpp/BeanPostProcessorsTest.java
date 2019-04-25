package com.dmslob.spring.core.advanced.bpp;

import com.dmslob.spring.core.advanced.beans.Player;
import com.dmslob.spring.core.advanced.beans.Report;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorsTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setUp() {
        context = new AnnotationConfigApplicationContext(BeanPostProcessorsConfiguration.class);
    }

    @Test
    public void testInjectRandomIntBPP() {
        Player player = context.getBean(Player.class);
        int stamina = player.getStamina();

        Assert.assertTrue("Injection of random int failed", stamina >= Player.MIN && stamina <= Player.MAX);
    }

    @Test
    public void testBenchmarkBPP() {
        Report report = (Report) context.getBean("workflowReport");
        report.build();

        Assert.assertNotNull(report);
    }
}
