package za.ac.cput.project.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.Supplier;
import za.ac.cput.project.domain.SupplierInvoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudSupplier {

    private Long id;

    @Autowired
    SupplierRepository repository;
    @Test
    public void testCreate() throws Exception {


        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        List<Supplier> suppliers = new ArrayList<Supplier>();
        Supplier supplier = new Supplier.
                Builder(54321l)
                .supplierName("itbooks")
                .supplierEmail("it@gmail.com")
                .supplierAddress("fasder street 123")
                .supplierContactDetails(12343512l)
                .supplierInvoice(supplierInvoices)
                .build();
        repository.save(supplier);
        id=supplier.getSupplierId();
        Assert.assertNotNull(supplier.getSupplierId());
    }

    @Test
    public void testRead() throws Exception {

        Supplier supplier = repository.findOne(id);
        Assert.assertEquals("itbooks", supplier.getSupplierName());

    }

    @Test
    public void testUpdate() throws Exception {


        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        Supplier supplier = repository.findOne(id);
        Supplier newSupplier = new Supplier.
                Builder(54321l)
                .supplierName("itbook")
                .supplierEmail("it@gmail.com")
                .supplierAddress("fasder street 123")
                .supplierContactDetails(12343512l)
                .supplierInvoice(supplierInvoices)
                .build();
        repository.save(newSupplier);
        Assert.assertEquals("itbook", supplier.getSupplierName());


    }

    @Test
    public void testDelete() throws Exception {

        Supplier supplier = repository.findOne(id);
        repository.delete(supplier);
        Supplier newSupplier = repository.findOne(id);
        Assert.assertNull(newSupplier);
    }
}
