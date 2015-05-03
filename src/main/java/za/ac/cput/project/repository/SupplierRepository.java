package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.Supplier;

/**
 * Created by student on 2015/05/01.
 */
public interface SupplierRepository extends CrudRepository<Supplier,Long> {
    public Supplier findByCode(String code);
}
