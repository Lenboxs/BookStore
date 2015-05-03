package za.ac.cput.project.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.project.config.factory.TransactionLineFactory;

/**
 * Created by student on 2015/04/26.
 */
public class TransactionLineTest {

    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void testCreateTransactionLine() throws Exception {
        TransactionLine transactionLine = TransactionLineFactory.createTransactionLine(123l,100.00,10);

        Assert.assertEquals(new Long(123), transactionLine.getTransactionLineCode());

    }

    @Test
    public void testUpdateTransactionLine() throws Exception {
        TransactionLine transactionLine = TransactionLineFactory.createTransactionLine(123l,100.00,10);

        Assert.assertEquals(new Long(123), transactionLine.getTransactionLineCode());

        TransactionLine newTransactionLine = new TransactionLine
                .Builder(transactionLine.getTransactionLineCode())
                .copy(transactionLine)
                .transactionLineQuantitySold(6).build();

        Assert.assertEquals(new Long(123),newTransactionLine.getTransactionLineCode());
        Assert.assertEquals(6,newTransactionLine.getTransactionLineQuantitySold());
        Assert.assertEquals(10,transactionLine.getTransactionLineQuantitySold());
    }
}
