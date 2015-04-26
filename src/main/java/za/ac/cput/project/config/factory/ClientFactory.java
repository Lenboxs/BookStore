package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Client;
import za.ac.cput.project.domain.Order;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class ClientFactory {

    public static Client createClient(Map<String,Long>longValues, Map<String,String>value, List<Order> order){

        Client client = new Client
                .Builder(longValues.get("clientId"))
                .clientName(value.get("clientName"))
                .clientSurname(value.get("clientSurname"))
                .clientContactNumber(longValues.get("clientContactNumber"))
                .order(order)
                .build();

        return client;
    }

}
