package za.ac.cput.project.services;

import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Order;

import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
public interface ClientService {
    List<Client> getClient();
    List<Order> getOrder(Long id);
}
