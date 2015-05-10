package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.Book;

/**
 * Created by student on 2015/05/01.
 */
public interface BookRepository extends CrudRepository<Book,Long> {
     // Book findByCode(String code);
}
