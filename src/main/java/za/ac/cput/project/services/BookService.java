package za.ac.cput.project.services;

import za.ac.cput.project.domain.Book;
import za.ac.cput.project.domain.OrderLine;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.domain.TransactionLine;

import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
public interface BookService {

    List<Book> getBooks();
    List<OrderLine> getOrderLine(Long id);
    List<TransactionLine> getTransactionLine(Long id);
    List<SupplierInvoice> getSupplierInvoice(Long id);
}
