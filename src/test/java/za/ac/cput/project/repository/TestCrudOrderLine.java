package za.ac.cput.project.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.OrderLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudOrderLine {
    private Long id;

    @Autowired
    OrderLineRepository repository;

    @Test
    public void testCreate() throws Exception {

        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine
                .Builder(1234567890l)
                .quantityBought(123)
                .unitPrice(321.00)
                .build();
        repository.save(orderLine);
        id=orderLine.getOrderLineNumber();
        Assert.assertNotNull(orderLine.getOrderLineNumber());
    }

    @Test
    public void testRead() throws Exception {

        OrderLine orderLine = repository.findOne(id);
        Assert.assertEquals(new Long(1234567890), orderLine.getOrderLineNumber());

    }

    @Test
    public void testUpdate() throws Exception {

        OrderLine orderLine = repository.findOne(id);
        OrderLine newOrderLine = new OrderLine
                .Builder(1234567890l)
                .quantityBought(12)
                .unitPrice(32.00)
                .build();
        repository.save(newOrderLine);
        Assert.assertEquals(12, orderLine.getQuantityBought());
        Assert.assertEquals(32, orderLine.getUnitPrice());

    }

    @Test
    public void testDelete() throws Exception {

        OrderLine orderLine = repository.findOne(id);
        repository.delete(orderLine);
        OrderLine newOrderLine = repository.findOne(id);
        Assert.assertNull(newOrderLine);
    }
}
