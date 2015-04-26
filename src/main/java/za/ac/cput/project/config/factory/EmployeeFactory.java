package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.*;

import java.util.List;

/**
 * Created by student on 2015/04/20.
 */
public class EmployeeFactory {

    public static Employee createEmployee(  Long employeeId,
                                            Name name,
                                            Demographic demographic,
                                            ContactDetails contactDetails,
                                            List<Transaction> transaction ){

        Employee employee = new Employee
                .Builder(employeeId)
                .name(name)
                .contactDetails(contactDetails)
                .demographic(demographic)
                .build();
        return employee;

    }
}
