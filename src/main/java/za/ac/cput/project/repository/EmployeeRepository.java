package za.ac.cput.project.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.domain.Employee;

/**
 * Created by student on 2015/05/01.
 */
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    //public Employee findByCode(String code);
}
