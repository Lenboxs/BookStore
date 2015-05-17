package za.ac.cput.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.TransactionFactory;
import za.ac.cput.project.config.factory.TransactionLineFactory;
import za.ac.cput.project.domain.Transaction;
import za.ac.cput.project.domain.TransactionLine;
import za.ac.cput.project.repository.TransactionRepository;
import za.ac.cput.project.services.TransactionService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/05/17.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TransactionServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private TransactionService service;

    private Long id;

    @Autowired
    private TransactionRepository repository;
    //private List<TransactionLine> transactionLine;

    public void setUp() throws Exception {

        //transactionLine = new ArrayList<TransactionLine>();

    }
    @Test
    public void create() throws Exception {
        List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        Date date = new Date(2015,10,10);
       TransactionLine transactionLine1 = TransactionLineFactory
                .createTransactionLine(id, 100.00, 10);
        TransactionLine transactionLine2 = TransactionLineFactory
                .createTransactionLine(id, 150.00, 15);


        transactionLine.add(transactionLine1);
        transactionLine.add(transactionLine2);

        Transaction transaction = TransactionFactory
                .createTransaction(2, date, transactionLine);

        repository.save(transaction);
        id=transaction.getTransactionCode();
        Assert.assertNotNull(transaction.getTransactionCode());
    }


    @Test(dependsOnMethods = "create")
    public void testGetFacultyDepartmets() throws Exception {
        List<TransactionLine> transactionLine = service.getTransactionLine(id);
        Assert.assertTrue(transactionLine.size() == 2);

    }
}
