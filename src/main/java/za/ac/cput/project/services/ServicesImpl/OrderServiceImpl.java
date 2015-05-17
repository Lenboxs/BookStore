package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Order;
import za.ac.cput.project.domain.OrderLine;
import za.ac.cput.project.repository.OrderRepository;
import za.ac.cput.project.services.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository repository;
    public List<Order> getOrders() {
        List<Order> allOrders = new ArrayList<Order>();

        Iterable<Order> orders = repository.findAll();
        for (Order order : orders) {
            allOrders.add(order);
        }
        return allOrders;
    }

    @Override
    public List<OrderLine> getOrderLine(Long id) {
        return repository.findOne(id).getOrderLine();
    }

}
