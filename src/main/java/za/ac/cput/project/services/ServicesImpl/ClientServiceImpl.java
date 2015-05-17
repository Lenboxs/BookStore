package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Order;
import za.ac.cput.project.repository.ClientRepository;
import za.ac.cput.project.services.ClientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository repository;
    public List<Client> getClient() {
        List<Client> allClients = new ArrayList<Client>();

        Iterable<Client> clients = repository.findAll();
        for (Client client : clients) {
            allClients.add(client);
        }
        return allClients;
    }

    @Override
    public List<Order> getOrder(Long id) {
        return repository.findOne(id).getOrder();
    }
}
