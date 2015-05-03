package za.ac.cput.project.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.Order;
import za.ac.cput.project.domain.OrderLine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudOrder {
    private Long id;

    @Autowired
    OrderRepository repository;

    @Test
    public void testCreate() throws Exception {

        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        List<Order> orders = new ArrayList<Order>();
        Date date = new Date(2015,10,8);
        Order order = new Order
                .Builder(219879787L)
                .orderDate(date)
                .orderPayment(260.00)
                .orderLine(orderLine)
                .build();
        repository.save(order);
        id=order.getOrderId();
        Assert.assertNotNull(order.getOrderId());
    }

    @Test
    public void testRead() throws Exception {

        Order order = repository.findOne(id);
        Assert.assertEquals(260.00, order.getOrderPayment(),2);

    }

    @Test
    public void testUpdate() throws Exception {

        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        List<Order> orders = new ArrayList<Order>();
        Date date = new Date(2015,15,9);
        Order order = repository.findOne(id);
        Order newOrder = new Order
                .Builder(21987L)
                .orderDate(date)
                .orderPayment(270.00)
                .orderLine(orderLine)
                .build();
                repository.save(newOrder);
        Assert.assertEquals(new Long(21987), order.getOrderId());
        Assert.assertEquals(270.00, order.getOrderPayment(),2);

    }

    @Test
    public void testDelete() throws Exception {

        Order order = repository.findOne(id);
        repository.delete(order);
        Order newOrder = repository.findOne(id);
        Assert.assertNull(newOrder);
    }
}
