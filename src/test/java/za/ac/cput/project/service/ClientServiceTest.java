package za.ac.cput.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.ClientFactory;
import za.ac.cput.project.config.factory.OrderFactory;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Order;
import za.ac.cput.project.repository.ClientRepository;
import za.ac.cput.project.services.ClientService;

import java.util.*;

/**
 * Created by student on 2015/05/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ClientServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ClientService service;

    private Long id;

    @Autowired
    private ClientRepository repository;
    private List<Order> order ;

    public void setUp() throws Exception {

        order = new ArrayList<Order>();

    }
    @Test
    public void create() throws Exception {

        Date date = new Date(2015,10,10);
        Order order1 = OrderFactory
                .createOrder(12345L,date,100.00,null);
        Order order2 = OrderFactory
                .createOrder(12347L,date,100.00,null);

        order.add(order1);
        order.add(order2);

        Map<String, Long> lValues = new HashMap<String,Long>();

        lValues.put("clientId", 121212L);
        lValues.put("clientContactNumber",131313L);

        Map<String, String> values = new HashMap<String, String>();

        values.put("clientName","jan");
        values.put("clientSurname","deer");

        Client client = ClientFactory.createClient(lValues, values, order);

        repository.save(client);
        id=client.getClientId();
        Assert.assertNotNull(client.getClientId());
    }


    @Test(dependsOnMethods = "create")
    public void testGetFacultyDepartmets() throws Exception {
        List<Order> order = service.getOrder(id);
        Assert.assertTrue(order.size() == 2);

    }
}
