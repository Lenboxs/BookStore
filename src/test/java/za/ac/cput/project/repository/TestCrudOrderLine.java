package za.ac.cput.project.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.OrderLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudOrderLine extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    OrderLineRepository repository;

    @Test
    public void Create() throws Exception {

        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        OrderLine orderLine = new OrderLine
                .Builder(id)
                .quantityBought(123)
                .unitPrice(321.00)
                .build();
        repository.save(orderLine);
        id=orderLine.getOrderLineNumber();
        Assert.assertNotNull(orderLine.getOrderLineNumber());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        OrderLine orderLine = repository.findOne(id);
        //Assert.assertEquals(new Long(1234567890), orderLine.getOrderLineNumber());

    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

        OrderLine orderLine = repository.findOne(id);
        OrderLine newOrderLine = new OrderLine
                .Builder(id)
                .quantityBought(12)
                .unitPrice(32.00)
                .build();
        repository.save(newOrderLine);
        //Assert.assertEquals(12, orderLine.getQuantityBought());
        //Assert.assertEquals(32, orderLine.getUnitPrice());

    }

    @Test(dependsOnMethods = "Update")
    public void testDelete() throws Exception {

        OrderLine orderLine = repository.findOne(id);
        repository.delete(orderLine);
        OrderLine newOrderLine = repository.findOne(id);
        Assert.assertNull(newOrderLine);
    }
}
