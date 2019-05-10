package com.dmslob.service;

import com.dmslob.dao.ClientDao;
import com.dmslob.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AccountService accountService;

    public List<Client> getAll() {
        clientDao.findAll();
        clientDao.findAll();
        return clientDao.findAll();
    }

    public List<Client> getAll(int limit) {
        List<Client> clients = clientDao.findAll();
        if (limit > clients.size()) {
            throw new IllegalArgumentException("Limit value incorrect");
        }
        return clientDao.findAll().subList(0, limit);
    }

    public Client getByCode(String code) {
        if (null == code) {
            throw new NullPointerException("No code");
        }
        return clientDao.findByCode(code);
    }

    public boolean save(Client client) {
        return clientDao.save(client);
    }

    public boolean verifyClient(Client client, AccountService accountService) {
        if (client != null && client.getCode().equals("1234")) {
            return true;
        }
        if (accountService != null && accountService.check(client) < 500) {
            return true;
        }
        return false;
    }
}
