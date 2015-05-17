package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Supplier;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.repository.SupplierRepository;
import za.ac.cput.project.services.SupplierService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierRepository repository;
    public List<Supplier> getSupplier() {
        List<Supplier> allSuppliers = new ArrayList<Supplier>();

        Iterable<Supplier> suppliers = repository.findAll();
        for (Supplier supplier : suppliers) {
            allSuppliers.add(supplier);
        }
        return allSuppliers;
    }

    @Override
    public List<SupplierInvoice> getSupplierInvoice(Long id) {
        return repository.findOne(id).getSupplierInvoice();
    }
}
