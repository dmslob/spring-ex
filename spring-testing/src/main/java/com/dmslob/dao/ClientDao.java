package com.dmslob.dao;

import com.dmslob.entity.Client;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientDao implements AbstractDao {

    private List<Client> clients = new ArrayList<Client>();
    private long idCounter = 0;

    @PostConstruct
    public void init() {
        clients.add(new Client(getNewId(), "Uncle Bob", "1234"));
        clients.add(new Client(getNewId(), "Jhon Smith", "5678"));
        clients.add(new Client(getNewId(), "Ann Davis", "1256"));
        clients.add(new Client(getNewId(), "Julia Lopez", "1098"));
    }

    public List<Client> findAll() {
        return clients;
    }

    public Client findByCode(String code) {
        Client client = null;
        for (Client c : clients) {
            if (code.equals(c.getCode())) {
                client = c;
            }
        }
        return client;
    }

    public boolean save(Client client) {
        if (client != null) {
            client.setId(getNewId());
            clients.add(client);
            return true;
        }
        return false;
    }

    private long getNewId() {
        long id = ++idCounter;
        return id;
    }
}
