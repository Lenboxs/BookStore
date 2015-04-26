package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.SupplierFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class SupplierTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateSupplier() throws Exception {
        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        Map<String,String> value = new HashMap<String,String>();

        value.put("supplierName","qwer");
        value.put("supplierEmail","asdf");
        value.put("supplierAddress","zxcv");

        Supplier supplier = SupplierFactory.createSupplier(123456789l,value,987654321l,supplierInvoices);

        Assert.assertEquals("qwer",supplier.getSupplierName());

    }

    @Test
    public void testUpdateSupplier() throws Exception {

        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        Map<String,String> value = new HashMap<String,String>();

        value.put("supplierName","qwer");
        value.put("supplierEmail","asdf");
        value.put("supplierAddress","zxcv");

        Supplier supplier = SupplierFactory.createSupplier(123456789L,value,987654321L,supplierInvoices);

        Assert.assertEquals("qwer",supplier.getSupplierName());

        Supplier newsupplier = new Supplier
                .Builder(supplier.getSupplierId())
                .copy(supplier)
                .supplierEmail("asdr")
                .build();
        Assert.assertEquals(new Long(123456789),newsupplier.getSupplierId());
        Assert.assertEquals("asdr",newsupplier.getSupplierEmail());
        Assert.assertEquals("asdf",supplier.getSupplierEmail());
    }
}
