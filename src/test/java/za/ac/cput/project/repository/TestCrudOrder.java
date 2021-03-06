package za.ac.cput.project.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
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
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudOrder extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    OrderRepository repository;

    @Test
    public void Create() throws Exception {

        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        List<Order> orders = new ArrayList<Order>();
        Date date = new Date(2015,10,8);
        Order order = new Order
                .Builder(id)
                .orderDate(date)
                .orderPayment(260.00)
                .orderLine(orderLine)
                .build();
        repository.save(order);
        id=order.getOrderId();
        Assert.assertNotNull(order.getOrderId());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        Order order = repository.findOne(id);

    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        List<Order> orders = new ArrayList<Order>();
        Date date = new Date(2015,15,9);
        Order order = repository.findOne(id);
        Order newOrder = new Order
                .Builder(id)
                .orderDate(date)
                .orderPayment(270.00)
                .orderLine(orderLine)
                .build();
                repository.save(newOrder);

    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        Order order = repository.findOne(id);
        repository.delete(order);
        Order newOrder = repository.findOne(id);
        Assert.assertNull(newOrder);
    }
}
