package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.OrderLine;

/**
 * Created by student on 2015/04/26.
 */
public class OrderLineFactory {

    public static OrderLine createOrderLine(Long orderLineNumber,
                                            int quantityBought,
                                            double unitPrice){

        OrderLine orderLine = new OrderLine
                .Builder(orderLineNumber)
                .quantityBought(quantityBought)
                .unitPrice(unitPrice)
                .build();
        return orderLine;
    }
}
