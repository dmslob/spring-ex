package com.dmslob.spring.core.scope;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TenantScopeConfig.class)
public class SpringCustomScopeTest {

    @Test
    public final void whenRegisterScopeAndBeans_thenContextContainsFooAndBar() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.register(TenantScopeConfig.class);
            ctx.refresh();

            TenantBean foo = (TenantBean) ctx.getBean("foo", TenantBean.class);
            foo.sayHello();

            TenantBean bar = (TenantBean) ctx.getBean("bar", TenantBean.class);
            bar.sayHello();

            Map<String, TenantBean> foos = ctx.getBeansOfType(TenantBean.class);

            assertThat(foo, not(equalTo(bar)));
            assertThat(foos.size(), equalTo(2));
            assertTrue(foos.containsValue(foo));
            assertTrue(foos.containsValue(bar));

            BeanDefinition fooDefinition = ctx.getBeanDefinition("foo");
            BeanDefinition barDefinition = ctx.getBeanDefinition("bar");

            assertThat(fooDefinition.getScope(), equalTo("tenant"));
            assertThat(barDefinition.getScope(), equalTo("tenant"));
        } finally {
            ctx.close();
        }
    }
}
