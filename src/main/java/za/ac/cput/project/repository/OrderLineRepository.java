package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.OrderLine;

/**
 * Created by student on 2015/05/01.
 */
public interface OrderLineRepository extends CrudRepository<OrderLine,Long> {
    //public OrderLine findByCode(String code);
}
