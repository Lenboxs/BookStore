package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Employee;
import za.ac.cput.project.domain.Transaction;
import za.ac.cput.project.repository.EmployeeRepository;
import za.ac.cput.project.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repository;
    public List<Employee> getEmployees() {
        List<Employee> allEmployees = new ArrayList<Employee>();

        Iterable<Employee> employees = repository.findAll();
        for (Employee employee : employees) {
            allEmployees.add(employee);
        }
        return allEmployees;
    }

    @Override
    public List<Transaction> getTransaction(Long id) {
        return repository.findOne(id).getTransaction();
    }
}
