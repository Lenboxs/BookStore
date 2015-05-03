package za.ac.cput.project.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudClient {

    private Long id;

    @Autowired
    ClientRepository repository;

    @Test
    public void testCreate() throws Exception {

        List<Order> order = new ArrayList<Order>();
        List<Client> clients = new ArrayList<Client>();
        Client client = new Client
                .Builder(id)
                .clientName("john")
                .clientSurname("Klaas")
                .clientContactNumber(12345678l)
                .order(order)
                .build();
        repository.save(client);
        id=client.getClientId();
        Assert.assertNotNull(client.getClientId());
    }

    @Test
    public void testRead() throws Exception {

        Client client = repository.findOne(id);
        Assert.assertEquals("john", client.getClientName());

    }

    @Test
    public void testUpdate() throws Exception {

        List<Order> order = new ArrayList<Order>();
        Client client = repository.findOne(id);
        Client newClient = new Client.
                Builder(id)
                .clientName("peter")
                .clientSurname("kami")
                .clientContactNumber(87654321l)
                .order(order)
                .build();
        repository.save(newClient);
        Assert.assertEquals("peter", client.getClientName());
        Assert.assertEquals("kami", client.getClientSurname());

    }

    @Test
    public void testDelete() throws Exception {

        Client client = repository.findOne(id);
        repository.delete(client);
        Client newClient = repository.findOne(id);
        Assert.assertNull(newClient);
    }
}
