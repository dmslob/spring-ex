package com.dmslob.spring.core.conditional;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MagicConfig.class})
public class ConditionalTest {

    @Autowired
    private MagicBean magicBean;

    @Autowired
    private Environment environment;

    @Test
    public void notNullBean() {
        System.out.println("magicBean is " + (magicBean != null));
        assertNotNull(magicBean);
    }

    @Test
    public void beanNameEquals() {
        String name = magicBean.getName();
        System.out.println("name = " + name);

        assertEquals("MagicBean", name);
    }

    @Test
    public void checkProperty() {
        String prop = environment.getProperty("greeting.preamble");
        System.out.println(prop);
    }
}
