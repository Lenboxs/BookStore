package za.ac.cput.project.repository;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudClient extends AbstractTestNGSpringContextTests{

    private Long id = null;

    @Autowired
    private ClientRepository repository;

    @Test
    public void Create() throws Exception {

        List<Order> order = new ArrayList<Order>();
        List<Client> clients = new ArrayList<Client>();
        Client client = new Client
                .Builder(id)
                .clientName("jimmy")
                .clientSurname("king")
                .clientContactNumber(12345678l)
                .order(order)
                .build();
        repository.save(client);
        id=client.getClientId();
        Assert.assertNotNull(client.getClientId());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        Client client = repository.findOne(id);


    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

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


    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        Client client = repository.findOne(id);
        repository.delete(client);
        Client newClient = repository.findOne(id);
        Assert.assertNull(newClient);
    }
}
