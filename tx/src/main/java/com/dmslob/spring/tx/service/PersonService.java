package com.dmslob.spring.tx.service;

import javax.persistence.EntityManager;
import javax.persistence.TransactionRequiredException;

import com.dmslob.spring.tx.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class PersonService implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    private ApplicationContext applicationContext;
    private EntityManager entityManager;

    @Autowired
    private AnotherPersonService anotherPersonService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.entityManager = this.applicationContext.getBean(EntityManager.class);
    }

    public void callTransactionalMethodsWithoutTrasaction() {
        LOGGER.info("================ callTransactionalMethodsWithoutTrasaction() =====================");
        LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
        LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());

        anotherPersonService.findWithRequired();
        //findWithRequired();
    }

    @Transactional
    public void callTransactionalMethodsWithTrasaction() {
        LOGGER.info("================ callTransactionalMethodsWithTrasaction() ========================");
        LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
        LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());

        Person person1 = new Person();
        person1.setFirstName("Person1");
        person1.setLastName("Person1");
        person1.setEmail("email1");
        entityManager.persist(person1);

        anotherPersonService.findWithRequired();
//        if (true) {
//            throw new TransactionRequiredException("did not persist");
//        }
        //required();
        //requiresNew();
//        nested();
//        supports();
//        notSupported();
//        never();
//        nested();
//        mandatory();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void findWithRequired() {
        entityManager.find(Person.class, new Long(1));

        LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
        LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        try {
            LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
            LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
            Person person3 = new Person();
            person3.setFirstName("Person3");
            person3.setLastName("Person3");
            person3.setEmail("email3");
            entityManager.persist(person3);
            LOGGER.info("This is from required()");
        } catch (Exception e) {
            LOGGER.error("Error in required() : {}", e.getClass());
            LOGGER.error("Error message : {}", e.getMessage());
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew() {
        try {
            LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
            LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
            LOGGER.info("Thread=" + Thread.currentThread().getName());

            Person person2 = new Person();
            person2.setFirstName("Person2");
            person2.setLastName("Person2");
            person2.setEmail("email2");
            entityManager.persist(person2);
            LOGGER.info("This is from requiresNew()");
        } catch (Exception e) {
            LOGGER.error("Error in requiresNew() : {}", e.getClass());
            LOGGER.error("Error message : {}", e.getMessage());
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory() {
        try {
            LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
            LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
            Person person4 = new Person();
            person4.setFirstName("Person4");
            person4.setLastName("Person4");
            person4.setEmail("email4");
            entityManager.persist(person4);
            LOGGER.info("This is from mandatory()");
        } catch (Exception e) {
            LOGGER.error("Error in mandatory() : {}", e.getClass());
            LOGGER.error("Error message : {}", e.getMessage());
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nested() {
        try {
            LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
            LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
            Person person5 = new Person();
            person5.setFirstName("Person5");
            person5.setLastName("Person5");
            person5.setEmail("email5");
            entityManager.persist(person5);
            LOGGER.info("This is from nested()");
        } catch (Exception e) {
            LOGGER.error("Error in nested() : {}", e.getClass());
            LOGGER.error("Error message : {}", e.getMessage());
        }
    }

    @Transactional(propagation = Propagation.NEVER)
    public void never() {
        LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
        LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
        LOGGER.info("This is from never()");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported() {
        LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
        LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
        LOGGER.info("This is from notSupported()");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports() {
        try {
            LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
            LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
            Person person7 = new Person();
            person7.setFirstName("Person8");
            person7.setLastName("Person8");
            person7.setEmail("email8");
            entityManager.persist(person7);
            LOGGER.info("This is from supports()");
        } catch (Exception e) {
            LOGGER.error("Error in supports() : {}", e.getClass());
            LOGGER.error("Error message : {}", e.getMessage());
        }
    }
}