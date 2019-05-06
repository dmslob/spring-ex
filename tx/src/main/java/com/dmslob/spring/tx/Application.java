package com.dmslob.spring.tx;

import com.dmslob.spring.tx.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        PersonService bean = context.getBean(PersonService.class);
        bean.callTransactionalMethodsWithTrasaction();
        //bean.callTransactionalMethodsWithoutTrasaction();
    }
}
