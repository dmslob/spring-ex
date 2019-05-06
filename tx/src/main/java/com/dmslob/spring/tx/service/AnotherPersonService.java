package com.dmslob.spring.tx.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class AnotherPersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnotherPersonService.class);

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void findWithRequired() {

        LOGGER.info("isActive=" + TransactionSynchronizationManager.isActualTransactionActive());
        LOGGER.info("Name=" + TransactionSynchronizationManager.getCurrentTransactionName());
    }
}
