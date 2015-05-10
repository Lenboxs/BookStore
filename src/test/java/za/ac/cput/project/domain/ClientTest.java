package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.ClientFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class ClientTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateClinet() throws Exception {
        List<Order> order = new ArrayList<Order>();
        Map<String, Long> lValues = new HashMap<String,Long>();

        lValues.put("clientId", 121212L);
        lValues.put("clientContactNumber",131313L);

        Map<String, String> values = new HashMap<String, String>();

        values.put("clientName","jan");
        values.put("clientSurname","deer");

        Client client = ClientFactory.createClient(lValues,values,order);

        Assert.assertEquals(new Long(121212), client.getClientId());


    }

    @Test
    public void testUpdateClient() throws Exception {

        List<Order> order = new ArrayList<Order>();
        Map<String, Long> lValues = new HashMap<String,Long>();

        lValues.put("clientId", 121212L);
        lValues.put("clientContactNumber",131313L);

        Map<String, String> values = new HashMap<String, String>();

        values.put("clientName","jan");
        values.put("clientSurname","deer");

        Client client = ClientFactory.createClient(lValues,values,order);

        Assert.assertEquals(new Long(121212), client.getClientId());

        Client newclient = new Client
                .Builder(client.getClientId())
                .copy(client)
                .clientName("ben")
                .build();

        Assert.assertEquals(new Long(121212), newclient.getClientId());
        Assert.assertEquals("ben",newclient.getClientName());
        Assert.assertEquals("jan",client.getClientName());

    }
}
