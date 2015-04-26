package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.BookFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/17.
 */
public class BookTest {
    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateBook() throws Exception {
        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        List<SupplierInvoice> supplierInvoice = new ArrayList<SupplierInvoice>();
        Map<String,String> values = new HashMap<String, String>();

        values.put("bookName","pets");
        values.put("bookAuther","jani");
        values.put("bookPublisher","worldbooks");

        Book book = BookFactory.createBook(132435L,values,100.99,10,orderLine,transactionLine,supplierInvoice);

        Assert.assertEquals(new Long(132435),book.getBookCode());

    }

    @Test
    public void testUpdateBook() throws Exception {
        List<OrderLine> orderLine = new ArrayList<OrderLine>();
        List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        List<SupplierInvoice> supplierInvoice = new ArrayList<SupplierInvoice>();
        Map<String,String> values = new HashMap<String, String>();

        values.put("bookName","pets");
        values.put("bookAuther","jani");
        values.put("bookPublisher","worldbooks");

        Book book = BookFactory.createBook(132435L,values,100.99,10,orderLine,transactionLine,supplierInvoice);

        Assert.assertEquals(new Long(132435),book.getBookCode());

        Book newbook = new Book
                .Builder(book.getBookCode())
                .copy(book)
                .bookQuantity(4)
                .build();

        Assert.assertEquals(new Long(132435),book.getBookCode());
        Assert.assertEquals(4, newbook.getBookQuantity());
        Assert.assertEquals(10, book.getBookQuantity());

    }
}
