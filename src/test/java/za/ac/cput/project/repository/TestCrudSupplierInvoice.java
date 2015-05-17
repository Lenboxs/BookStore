package za.ac.cput.project.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.SupplierInvoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudSupplierInvoice extends AbstractTestNGSpringContextTests{

    private Long id = null;

    @Autowired
    private SupplierInvoiceRepository repository;

    @Test
    public void Create() throws Exception {

        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        SupplierInvoice supplierInvoice = new SupplierInvoice
                .Builder(id)
                .quantity(12)
                .build();
        repository.save(supplierInvoice);
        id=supplierInvoice.getSupplierInvoiceId();
        Assert.assertNotNull(supplierInvoice.getSupplierInvoiceId());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        SupplierInvoice supplierInvoice = repository.findOne(id);
        //Assert.assertEquals(12, supplierInvoice.getQuantity());

    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

        SupplierInvoice supplierInvoice = repository.findOne(id);
        SupplierInvoice newSupplierInvoice = new SupplierInvoice.
                Builder(id)
                .quantity(23)
                .build();
        repository.save(newSupplierInvoice);
        //Assert.assertEquals(23, supplierInvoice.getQuantity());

    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        SupplierInvoice supplierInvoice = repository.findOne(id);
        repository.delete(supplierInvoice);
        SupplierInvoice newSupplierInvoice = repository.findOne(id);
        Assert.assertNull(newSupplierInvoice);
    }
}
