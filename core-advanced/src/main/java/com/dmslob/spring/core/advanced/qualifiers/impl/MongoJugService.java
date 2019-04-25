package com.dmslob.spring.core.advanced.qualifiers.impl;

import com.dmslob.spring.core.advanced.qualifiers.Dao;
import com.dmslob.spring.core.advanced.qualifiers.JugService;
import com.dmslob.spring.core.advanced.qualifiers.Mongo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MongoJugService implements JugService {

    private static final Logger LOGGER = LogManager.getLogger(MongoJugService.class);

    @Mongo
    private Dao dao;

    @Override
    @PostConstruct
    public void doWork() {
        LOGGER.info("MongoJugService");
        dao.crud();
    }
}
