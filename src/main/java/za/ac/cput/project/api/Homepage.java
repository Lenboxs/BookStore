package za.ac.cput.project.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@RestController
@RequestMapping("/api/**")
public class Homepage {

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }


}

