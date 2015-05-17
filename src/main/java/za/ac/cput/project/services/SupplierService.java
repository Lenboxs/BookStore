package za.ac.cput.project.services;

import za.ac.cput.project.domain.Supplier;
import za.ac.cput.project.domain.SupplierInvoice;

import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
public interface SupplierService {
    List<Supplier> getSupplier();
    List<SupplierInvoice> getSupplierInvoice(Long id);
}
