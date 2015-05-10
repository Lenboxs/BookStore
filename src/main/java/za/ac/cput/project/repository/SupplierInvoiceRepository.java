package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.SupplierInvoice;

/**
 * Created by student on 2015/05/01.
 */
public interface SupplierInvoiceRepository extends CrudRepository<SupplierInvoice,Long> {
    //public SupplierInvoice findByCode(String code);
}
