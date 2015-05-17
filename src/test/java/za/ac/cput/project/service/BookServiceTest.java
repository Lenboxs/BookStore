package za.ac.cput.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.OrderLine;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.domain.TransactionLine;
import za.ac.cput.project.repository.BookRepository;
import za.ac.cput.project.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class BookServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private BookService service;

    private Long id;

    @Autowired
    private BookRepository repository;
    private List<OrderLine> orderLines;
    private List<TransactionLine> transactionLines;
    private List<SupplierInvoice> supplierInvoices;
    @BeforeMethod
    public void setUp() throws Exception {

        orderLines = new ArrayList<OrderLine>();
        transactionLines = new ArrayList<TransactionLine>();
        supplierInvoices = new ArrayList<SupplierInvoice>();

    }
    @Test
    public void create() throws Exception {

       /* ContactAddress deptaddress = ContactFactory
                .createContact("dept@test.com", "7550");
        Department it = DepartmentFactory
                .createDepartment(deptaddress, "IT", null);
        Department arts = DepartmentFactory
                .createDepartment(deptaddress, "ART", null);

        ContactAddress facultyaddress = ContactFactory
                .createContact("faculty@test.com", "7550");


        departments.add(it);
        departments.add(arts);

        Faculty faculty = FacultyFactory
                .createFaculty(facultyaddress, departments, "FID");

        repository.save(faculty);
        id=faculty.getId();
        Assert.assertNotNull(faculty.getId());*/
    }


    @Test
    public void testGetFacultyDepartmets() throws Exception {
        List<OrderLine> orderLines = service.getOrderLine(id);
        Assert.assertTrue(orderLines.size() == 1);

    }
}
