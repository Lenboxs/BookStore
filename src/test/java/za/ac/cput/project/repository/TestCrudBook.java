package za.ac.cput.project.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudBook {
    private Long id;

    @Autowired
    BookRepository repository;
    @Test
    public void testCreate() throws Exception {

        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        List<TransactionLine> transactionLines = new ArrayList<TransactionLine>();
        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        List<Book> books = new ArrayList<Book>();
        Book book = new Book.
                Builder(id)
                .bookName("the one").
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

    @Test
    public void testRead() throws Exception {

        Book book = repository.findOne(id);
        Assert.assertEquals("the one", book.getBookName());

    }

    @Test
    public void testUpdate() throws Exception {

        List<OrderLine> orderLines = new ArrayList<OrderLine>();
        List<TransactionLine> transactionLines = new ArrayList<TransactionLine>();
        List<SupplierInvoice> supplierInvoices = new ArrayList<SupplierInvoice>();
        Book book = repository.findOne(id);
        Book newBook = new Book.
                Builder(id).
                bookName("the Two").
                bookAuther("lenny").
                bookPublisher("barnardo").
                bookPrice(150.00).
                bookQuantity(15).
                orderLine(orderLines).
                transactionLine(transactionLines).
                supplierInvoice(supplierInvoices).
                build();
        repository.save(newBook);
        Assert.assertEquals("the Two", book.getBookName());
        Assert.assertEquals("lenny", book.getBookAuther());

    }

    @Test
    public void testDelete() throws Exception {

        Book book = repository.findOne(id);
        repository.delete(book);
        Book newBook = repository.findOne(id);
        Assert.assertNull(newBook);
    }
}
