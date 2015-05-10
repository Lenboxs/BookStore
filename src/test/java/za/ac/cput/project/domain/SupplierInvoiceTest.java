package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.SupplierInvoiceFactory;


/**
 * Created by student on 2015/04/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class SupplierInvoiceTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateSupplierInvoice() throws Exception {
        SupplierInvoice supplierInvoice =SupplierInvoiceFactory.createSupplierInvoice(1231239l,2);

        Assert.assertEquals(new Long(1231239),supplierInvoice.getSupplierInvoiceId() );



    }

    @Test
    public void testUpdateSupplierInvoice() throws Exception {

        SupplierInvoice supplierInvoice =SupplierInvoiceFactory.createSupplierInvoice(1231239l,2);

        Assert.assertEquals(new Long(1231239),supplierInvoice.getSupplierInvoiceId() );

        SupplierInvoice newSupplierInvoice = new SupplierInvoice
                .Builder(supplierInvoice.getSupplierInvoiceId())
                .copy(supplierInvoice)
                .quantity(5)
                .build();

        Assert.assertEquals(new Long(1231239),newSupplierInvoice.getSupplierInvoiceId());
        Assert.assertEquals(5,newSupplierInvoice.getQuantity());
        Assert.assertEquals(2,supplierInvoice.getQuantity());

    }
}
