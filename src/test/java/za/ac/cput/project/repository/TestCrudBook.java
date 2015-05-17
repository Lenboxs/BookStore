package za.ac.cput.project.repository;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.Book;
import za.ac.cput.project.domain.OrderLine;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.domain.TransactionLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudBook extends AbstractTestNGSpringContextTests {
    //private Long id = null;
    private Long id;

    @Autowired
    private BookRepository repository;
    @Test
    public void Create() throws Exception {

        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        List<TransactionLine> transactionLines = new ArrayList<TransactionLine>();
        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        List<Book> books = new ArrayList<Book>();
        Book book = new Book.
                Builder(id)
                .bookName("the three").
                bookAuther("lennybot").
                bookPublisher("the Botha").
                bookPrice(100.00).
                bookQuantity(12).
                orderLine(orderLines).
                transactionLine(transactionLines).
                supplierInvoice(supplierInvoices).
                build();
        repository.save(book);
        id=book.getBookCode();
        Assert.assertNotNull(book.getBookCode());

    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        Book book = repository.findOne(id);
        Assert.assertEquals("the three", book.getBookName());

    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        List<TransactionLine> transactionLines = new ArrayList<TransactionLine>();
        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        Book book = repository.findOne(id);
        Book newBook = new Book.
                Builder(id).
                bookName("the jimmy two").
                bookAuther("lenny").
                bookPublisher("barnardo").
                bookPrice(150.00).
                bookQuantity(15).
                orderLine(orderLines).
                transactionLine(transactionLines).
                supplierInvoice(supplierInvoices).
                build();
        repository.save(newBook);
        Assert.assertEquals("the three", book.getBookName());
        Assert.assertEquals("lennybot", book.getBookAuther());

    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        Book book = repository.findOne(id);
        repository.delete(book);
        Book newBook = repository.findOne(id);
        Assert.assertNull(newBook);
    }
}
