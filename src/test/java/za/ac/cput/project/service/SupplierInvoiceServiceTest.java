package za.ac.cput.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.SupplierInvoiceFactory;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.repository.SupplierInvoiceRepository;
import za.ac.cput.project.services.SupplierInvoiceService;

import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class SupplierInvoiceServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SupplierInvoiceService service;
    private Long id;

    @Autowired
    private SupplierInvoiceRepository repository;

    public void setUp() throws Exception {
    }
    @Test
    public void create() throws Exception {

        SupplierInvoice supplierInvoice = SupplierInvoiceFactory
                .createSupplierInvoice(id, 10);

        repository.save(supplierInvoice);
        id=supplierInvoice.getSupplierInvoiceId();
        Assert.assertNotNull(supplierInvoice.getSupplierInvoiceId());
    }

    @Test
    public void testGetFacultyDepartmets() throws Exception {
        List<SupplierInvoice> supplierInvoice = service.getSupplierInvoice();
        Assert.assertTrue(supplierInvoice.size() == 1);

    }
}
