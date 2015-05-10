package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.App;
import za.ac.cput.project.config.factory.TransactionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 * Created by student on 2015/04/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class TransactionTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateTransactionTest() throws Exception {
        List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        Date date = new Date();
        Transaction transaction = TransactionFactory.createTransaction(123l,date,transactionLine);

        Assert.assertEquals(new Long(123),transaction.getTransactionCode());
    }

    @Test
    public void testUpdateTransactionTest() throws Exception {
        List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        Date date = new Date(2015,04,06);
        Transaction transaction = TransactionFactory.createTransaction(123l,date,transactionLine);

        Assert.assertEquals(new Long(123),transaction.getTransactionCode());

        Transaction newtransaction = new Transaction
                .Builder(transaction.getTransactionCode())
                .copy(transaction)
                .transactionDate(new Date(2015, 10, 10))
                .build();

        Assert.assertEquals(new Long(123),newtransaction.getTransactionCode());
        Assert.assertEquals(new Date(2015, 10, 10),newtransaction.getTransactionDate());
        Assert.assertEquals(new Date(2015,04,06),transaction.getTransactionDate());

    }
}
