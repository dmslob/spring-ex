package com.dmslob.spring.core.advanced.qualifiers.impl;

import com.dmslob.spring.core.advanced.qualifiers.JugService;
import com.dmslob.spring.core.advanced.qualifiers.Dao;
import com.dmslob.spring.core.advanced.qualifiers.Oracle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 24/06/2014.
 */
@Service
public class OracleJugService implements JugService {

    private static final Logger LOGGER = LogManager.getLogger(OracleJugService.class);

    @Oracle
    private Dao dao;

    @Override
    @PostConstruct
    public void doWork() {
        LOGGER.info("OracleJugService");
        dao.crud();
    }
}
