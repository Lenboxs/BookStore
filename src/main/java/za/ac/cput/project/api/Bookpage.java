package za.ac.cput.project.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.project.domain.Book;
import za.ac.cput.project.services.BookService;

import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@RestController
@RequestMapping(value="/Book/**")
public class Bookpage {

}

