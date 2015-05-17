package za.ac.cput.project.repository;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.domain.Transaction;
import za.ac.cput.project.domain.TransactionLine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/05/01.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TestCrudTransaction extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    TransactionRepository repository;

    @Test
    public void Create() throws Exception {

        List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        Date date = new Date(2015,10,10);
        List<Transaction> transactions = new ArrayList<Transaction>();
        Transaction transaction = new Transaction
                .Builder(id)
                .transactionDate(date)
                .transactionLine(transactionLine)
                .build();
        repository.save(transaction);
        id=transaction.getTransactionCode();
        Assert.assertNotNull(transaction.getTransactionCode());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception {
        //Date date = new Date(2015,10,10);
        Transaction transaction = repository.findOne(id);
        //Assert.assertEquals(date, transaction.getTransactionDate());

    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception {

        List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        Date date = new Date(2015,10,11);
        Transaction transaction = repository.findOne(id);
        Transaction newTransaction = new Transaction.
                Builder(id)
                .transactionDate(date)
                .transactionLine(transactionLine)
                .build();
        repository.save(newTransaction);
       // Assert.assertEquals(date, transaction.getTransactionDate());


    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception {

        /*Transaction transaction = repository.findOne(id);
        repository.delete(transaction);
        Transaction newTransaction = repository.findOne(id);
        Assert.assertNull(newTransaction);*/
    }
}
