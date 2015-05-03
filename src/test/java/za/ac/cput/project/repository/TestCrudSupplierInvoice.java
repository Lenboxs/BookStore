package za.ac.cput.project.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.SupplierInvoice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudSupplierInvoice {

    private long id;

    @Autowired
    SupplierInvoiceRepository repository;

    @Test
    public void testCreate() throws Exception {

        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        SupplierInvoice supplierInvoice = new SupplierInvoice
                .Builder(246810l)
                .quantity(12)
                .build();
        repository.save(supplierInvoice);
        id=supplierInvoice.getSupplierInvoiceId();
        Assert.assertNotNull(supplierInvoice.getSupplierInvoiceId());
    }

    @Test
    public void testRead() throws Exception {

        SupplierInvoice supplierInvoice = repository.findOne(id);
        Assert.assertEquals(12, supplierInvoice.getQuantity());

    }

    @Test
    public void testUpdate() throws Exception {

        SupplierInvoice supplierInvoice = repository.findOne(id);
        SupplierInvoice newSupplierInvoice = new SupplierInvoice.
                Builder(246810l)
                .quantity(23)
                .build();
        repository.save(newSupplierInvoice);
        Assert.assertEquals(23, supplierInvoice.getQuantity());

    }

    @Test
    public void testDelete() throws Exception {

        SupplierInvoice supplierInvoice = repository.findOne(id);
        repository.delete(supplierInvoice);
        SupplierInvoice newSupplierInvoice = repository.findOne(id);
        Assert.assertNull(newSupplierInvoice);
    }
}
