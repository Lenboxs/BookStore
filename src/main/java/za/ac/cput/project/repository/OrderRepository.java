package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.Order;

/**
 * Created by student on 2015/05/01.
 */
public interface OrderRepository extends CrudRepository<Order,Long> {
    public Order findByCode(String code);
}
