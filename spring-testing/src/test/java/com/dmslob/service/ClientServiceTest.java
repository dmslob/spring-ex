package com.dmslob.service;

import static org.junit.Assert.*;

import com.dmslob.config.AppConfig;
import com.dmslob.dao.ClientDao;
import com.dmslob.entity.Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.hamcrest.Matchers;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @Mock
    private ClientDao clientDao;

    @Mock
    private AccountService accountService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void clientServiceTest() {
        assertNotNull(clientService);
    }

    @Test
    public void getClientByCode() {
        String code = "1234";
        Client client = clientService.getByCode(code);

        assertThat(client, Matchers.notNullValue());
        //assertNotNull(client);
    }

    @Test
    public void getAllClientsTest() {
        List<Client> clients = clientService.getAll();
        assertThat(clients, Matchers.notNullValue());
    }

    @Test
    public void getLimitedClientsTest() {
        List<Client> clients = clientService.getAll(2);
        assertThat(clients, Matchers.hasSize(2));
    }

    @Test
    public void saveClientTest() {
        Client client = new Client();
        client.setName("Jacky Dawson");
        client.setCode("3256");
        boolean isSaved = clientService.save(client);

        assertTrue(isSaved);
    }

    @Test
    public void verifyClientTest() {
        Client client = Mockito.mock(Client.class);
        Mockito.when(client.getCode()).thenReturn("1234");

        boolean isVerified = clientService.verifyClient(client, accountService);

        assertTrue(isVerified);
    }

    @Test
    public void verifyAccountTest() {
        Client client = Mockito.mock(Client.class);
        Mockito.when(client.getCode()).thenReturn("5234");
        Mockito.when(accountService.check(client)).thenReturn(400);
        boolean isVerified = clientService.verifyClient(client, accountService);

        assertTrue(isVerified);
    }

    @Test
    public void clientDaoTest() {
        ReflectionTestUtils.setField(clientService, "clientDao", clientDao);
        clientService.getAll();
        Mockito.verify(clientDao, Mockito.times(3)).findAll();
    }

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        assertEquals(100, mockList.size());
    }
}
