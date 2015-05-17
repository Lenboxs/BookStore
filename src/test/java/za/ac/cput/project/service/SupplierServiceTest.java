package za.ac.cput.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.SupplierFactory;
import za.ac.cput.project.config.factory.SupplierInvoiceFactory;
import za.ac.cput.project.domain.Supplier;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.repository.SupplierRepository;
import za.ac.cput.project.services.SupplierService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/05/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SupplierServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private SupplierService service;

    private Long id;

    @Autowired
    private SupplierRepository repository;
    private List<SupplierInvoice> supplierInvoice;

    public void setUp() throws Exception {

        supplierInvoice = new ArrayList<SupplierInvoice>();

    }
    @Test
    public void create() throws Exception {


        SupplierInvoice supplierInvoice1 = SupplierInvoiceFactory
                .createSupplierInvoice(12346l, 10);
        SupplierInvoice supplierInvoice2 = SupplierInvoiceFactory
                .createSupplierInvoice(12345l, 15);


        supplierInvoice.add(supplierInvoice1);
        supplierInvoice.add(supplierInvoice2);

        Map<String,String> value = new HashMap<String,String>();

        value.put("supplierName","qwer");
        value.put("supplierEmail","asdf");
        value.put("supplierAddress","zxcv");


        Supplier supplier = SupplierFactory
                .createSupplier(id, value,0744221176l, supplierInvoice);

        repository.save(supplier);
        id=supplier.getSupplierId();
        Assert.assertNotNull(supplier.getSupplierId());
    }


    @Test
    public void testGetFacultyDepartmets() throws Exception {
        List<SupplierInvoice> supplierInvoice = service.getSupplierInvoice(id);
        Assert.assertTrue(supplierInvoice.size() == 2);

    }
}
