package com.dmslob.dao;

import com.dmslob.entity.Client;

import java.util.List;

public interface AbstractDao {

    List<Client> findAll();

    Client findByCode(String code);

    boolean save(Client client);
}
