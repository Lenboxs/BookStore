package za.ac.cput.project.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.Supplier;
import za.ac.cput.project.domain.SupplierInvoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudSupplier extends AbstractTestNGSpringContextTests{

    private Long id = null;

    @Autowired
    private SupplierRepository repository;
    @Test
    public void Create() throws Exception {


        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        List<Supplier> suppliers = new ArrayList<Supplier>();
        Supplier supplier = new Supplier.
                Builder(id)
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

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        Supplier supplier = repository.findOne(id);
        //Assert.assertEquals("itbooks", supplier.getSupplierName());

    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {


        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        Supplier supplier = repository.findOne(id);
        Supplier newSupplier = new Supplier.
                Builder(id)
                .supplierName("itbook")
                .supplierEmail("it@gmail.com")
                .supplierAddress("fasder street 123")
                .supplierContactDetails(12343512l)
                .supplierInvoice(supplierInvoices)
                .build();
        repository.save(newSupplier);
       // Assert.assertEquals("itbook", supplier.getSupplierName());


    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        Supplier supplier = repository.findOne(id);
        repository.delete(supplier);
        Supplier newSupplier = repository.findOne(id);
        Assert.assertNull(newSupplier);
    }
}
