package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Book;
import za.ac.cput.project.domain.OrderLine;
import za.ac.cput.project.domain.SupplierInvoice;
import za.ac.cput.project.domain.TransactionLine;
import za.ac.cput.project.repository.BookRepository;
import za.ac.cput.project.services.BookService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository repository;
    public List<Book> getBooks() {
        List<Book> allBooks = new ArrayList<Book>();

        Iterable<Book> books = repository.findAll();
        for (Book book : books) {
            allBooks.add(book);
        }
        return allBooks;
    }
    @Override
    public List<OrderLine> getOrderLine(Long id) {
        return repository.findOne(id).getOrderLine();
    }

    @Override
    public List<TransactionLine> getTransactionLine(Long id) {
        return repository.findOne(id).getTransactionLine();
    }

    @Override
    public List<SupplierInvoice> getSupplierInvoice(Long id) {
        return repository.findOne(id).getSupplierInvoice();
    }

}
