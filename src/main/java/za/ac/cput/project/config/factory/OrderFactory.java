package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Order;
import za.ac.cput.project.domain.OrderLine;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class OrderFactory {

    public static Order createOrder(Long orderId,
                                    Date orderDate,
                                    double orderPayment,
                                    List<OrderLine> orderLine ){
        Order order = new Order
                .Builder(orderId)
                .orderDate(orderDate)
                .orderPayment(orderPayment)
                .orderLine(orderLine)
                .build();
        return order;
    }
}
