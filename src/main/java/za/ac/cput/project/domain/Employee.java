package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    public Long getEmployeeId() {
        return employeeId;
    }

}
