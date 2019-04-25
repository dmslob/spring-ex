package com.dmslob.spring.core.advanced.qualifiers.impl;

import com.dmslob.spring.core.advanced.qualifiers.Dao;
import com.dmslob.spring.core.advanced.qualifiers.Oracle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Oracle
public class OracleDao implements Dao {

    private static final Logger LOGGER = LogManager.getLogger(OracleDao.class);

    @Override
    public void crud() {
        LOGGER.info("OracleDao");
    }
}
