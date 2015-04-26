package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Book;
import za.ac.cput.project.domain.OrderLine;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.domain.TransactionLine;

import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class BookFactory {

    public static Book createBook(Long bookCode, Map<String,String> values,
                                  double bookPrice,
                                  int bookQuantity,
                                  List<OrderLine> orderLine,
                                  List<TransactionLine> transactionLine,
                                  List<SupplierInvoice> supplierInvoice){

        Book book = new Book.Builder(bookCode).
                            bookName(values.get("Name")).
                            bookAuther(values.get("bookAuther")).
                            bookPublisher(values.get("bookPublisher")).
                            bookPrice(bookPrice).
                            bookQuantity(bookQuantity).
                            orderLine(orderLine).
                            transactionLine(transactionLine).
                            supplierInvoice(supplierInvoice).
                            build();

        return book;


    }
}
