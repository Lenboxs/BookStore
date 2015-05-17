package za.ac.cput.project.services;

import za.ac.cput.project.domain.Order;
import za.ac.cput.project.domain.OrderLine;

import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
public interface OrderService {
    List<Order> getOrders();
    List<OrderLine> getOrderLine(Long id);
}
