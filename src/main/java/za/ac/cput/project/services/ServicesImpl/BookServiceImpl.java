package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Book;
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
}
