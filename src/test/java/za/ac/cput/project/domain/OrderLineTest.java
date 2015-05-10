package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.OrderLineFactory;

/**
 * Created by student on 2015/04/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class OrderLineTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateOrderLine() throws Exception {

        OrderLine orderLine = OrderLineFactory.createOrderLine(11223344L,15,50.00);

        Assert.assertEquals(15, orderLine.getQuantityBought());

    }

    @Test
    public void testUpdateOrderLine() throws Exception {
        OrderLine orderLine = OrderLineFactory.createOrderLine(11223344L,15,50.00);

        Assert.assertEquals(15, orderLine.getQuantityBought());


        OrderLine neworderLine = new OrderLine
                .Builder(orderLine.getOrderLineNumber())
                .copy(orderLine)
                .unitPrice(60.00)
                .build();

        Assert.assertEquals(new Long(11223344), neworderLine.getOrderLineNumber());
        Assert.assertEquals(60.00,neworderLine.getUnitPrice(),2);
        Assert.assertEquals(50.00,orderLine.getUnitPrice(),2);

    }
}
