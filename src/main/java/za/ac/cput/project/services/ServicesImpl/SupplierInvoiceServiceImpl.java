package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.repository.SupplierInvoiceRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class SupplierInvoiceServiceImpl {


    @Autowired
    SupplierInvoiceRepository repository;
    public List<SupplierInvoice> getSupplierInvoice() {
        List<SupplierInvoice> allSupplierInvoices = new ArrayList<SupplierInvoice>();

        Iterable<SupplierInvoice> supplierInvoices = repository.findAll();
        for (SupplierInvoice supplierInvoice : supplierInvoices) {
            allSupplierInvoices.add(supplierInvoice);
        }
        return allSupplierInvoices;
    }
}
