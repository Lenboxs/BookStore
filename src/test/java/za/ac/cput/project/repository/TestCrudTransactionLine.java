package za.ac.cput.project.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.TransactionLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TestCrudTransactionLine extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    TransactionLineRepository repository;

    @Test
    public void Create() throws Exception {

        List<TransactionLine> transactionLines= new ArrayList<TransactionLine>();
        TransactionLine transactionLine = new TransactionLine
                .Builder(id)
                .transactionLinePrice(150.99)
                .transactionLineQuantitySold(23)
                .build();
        repository.save(transactionLine);
        id=transactionLine.getTransactionLineCode();
        Assert.assertNotNull(transactionLine.getTransactionLineCode());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {

        TransactionLine transactionLine = repository.findOne(id);
        Assert.assertEquals(150.99, transactionLine.getTransactionLinePrice(),2);

    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

        TransactionLine transactionLine = repository.findOne(id);
        TransactionLine newTransactionLine = new TransactionLine.
                Builder(id)
                .transactionLinePrice(120.00)
                .transactionLineQuantitySold(10)
                .build();
        repository.save(newTransactionLine);
        Assert.assertEquals(150.99, transactionLine.getTransactionLinePrice(),2);
        Assert.assertEquals(23, transactionLine.getTransactionLineQuantitySold());

    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        TransactionLine transactionLine = repository.findOne(id);
        repository.delete(transactionLine);
        TransactionLine newTransactionLine = repository.findOne(id);
        Assert.assertNull(newTransactionLine);
    }
}
