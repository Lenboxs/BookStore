package za.ac.cput.project.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.ContactDetailsFactory;
import za.ac.cput.project.config.factory.DemographicFactory;
import za.ac.cput.project.config.factory.NameFactory;
import za.ac.cput.project.domain.ContactDetails;
import za.ac.cput.project.domain.Demographic;
import za.ac.cput.project.domain.Employee;
import za.ac.cput.project.domain.Name;

import java.util.*;

/**
 * Created by student on 2015/05/01.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudEmployee extends AbstractTestNGSpringContextTests{

    private Long id;

    @Autowired
    EmployeeRepository repository;
    @Test
    public void Create() throws Exception {

        Map<String,String> value = new HashMap<String, String>();
        value.put("employeeName","John");
        value.put("employeeSurname","Pieterse");
        Name name = NameFactory.createName(value);

        Map<String,String> value0 = new HashMap<String, String>();
        value0.put("employeeAddress","qweqwr street");
        value0.put("employeeEmail","qwer@asd.com");
        ContactDetails contactDetails = ContactDetailsFactory.createContactDetails(12345678l,value0);

        Map<String, String> value1 = new HashMap<String, String>();
        value1.put("race","coloured");
        value1.put("gender","male");
        Date dob = new Date(2015,12,1);
        Demographic demographic = DemographicFactory
                .createDemographic(value1, dob);

        List<Employee> employees = new ArrayList<Employee>();
        Employee employee = new Employee.
                Builder(id)
                .name(name)
                .contactDetails(contactDetails)
                .demographic(demographic)
                .build();
        repository.save(employee);
        id=employee.getEmployeeId();
        Assert.assertNotNull(employee.getEmployeeId());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        Employee employee = repository.findOne(id);


    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

        Employee employee = repository.findOne(id);
        Map<String,String> value = new HashMap<String, String>();
        value.put("employeeName","Billy");
        value.put("employeeSurname","Blue");
        Name newname = NameFactory.createName(value);

        Map<String,String> value0 = new HashMap<String, String>();
        value0.put("employeeAddress","qweqwr street");
        value0.put("employeeEmail","qwer@asd.com");
        ContactDetails newcontactDetails = ContactDetailsFactory.createContactDetails(12345678l,value0);

        Map<String, String> value1 = new HashMap<String, String>();
        value1.put("race","coloured");
        value1.put("gender","male");
        Date dob = new Date(2015,12,1);
        Demographic newdemographic = DemographicFactory
                .createDemographic(value1, dob);

        List<Employee> employees = new ArrayList<Employee>();
        Employee newEmployee = new Employee.
                Builder(id)
                .name(newname)
                .contactDetails(newcontactDetails)
                .demographic(newdemographic)
                .build();
        Assert.assertNotNull(employee.getEmployeeId());
        repository.save(newEmployee);



    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        Employee employee = repository.findOne(id);
        repository.delete(employee);
        Employee newEmployee = repository.findOne(id);
        Assert.assertNull(newEmployee);
    }
}
