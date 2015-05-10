package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.OrderFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class OrderTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateOrder() throws Exception {
        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        Date date = new Date(2015,2,2);

        Order order = OrderFactory.createOrder(12345L,date,100.00,orderLine);

        Assert.assertEquals(new Long(12345L),order.getOrderId());

    }

    @Test
    public void testUpdateOrder() throws Exception {

        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        Date date = new Date(2015,2,2);

        Order order = OrderFactory.createOrder(12345L,date,100.00,orderLine);

        Assert.assertEquals(new Long(12345L),order.getOrderId());

        Order neworder = new Order
                .Builder(order.getOrderId())
                .copy(order)
                .orderPayment(95.00)
                .build();

        Assert.assertEquals(new Long(12345L),neworder.getOrderId());
        Assert.assertEquals(95.00,neworder.getOrderPayment(),2);
        Assert.assertEquals(100.00,order.getOrderPayment(),2);

    }
}
