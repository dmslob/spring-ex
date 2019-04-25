package com.dmslob.spring.core.advanced.qualifiers.impl;

import com.dmslob.spring.core.advanced.qualifiers.Dao;
import com.dmslob.spring.core.advanced.qualifiers.Mongo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mongo
public class MongoDao implements Dao {

    private static final Logger LOGGER = LogManager.getLogger(MongoDao.class);

    @Override
    public void crud() {
        LOGGER.info("MongoDao.crud()");
    }
}
