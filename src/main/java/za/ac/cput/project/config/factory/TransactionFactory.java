package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Transaction;
import za.ac.cput.project.domain.TransactionLine;

import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/26.
 */
public class TransactionFactory {

    public static Transaction createTransaction(String transactionCode,
                                                Date transactionDate,
                                                List<TransactionLine> transactionLine){

        Transaction transaction = new Transaction
                .Builder(transactionCode)
                .transactionDate(transactionDate)
                .transactionLine(transactionLine)
                .build();

        return transaction;
    }
}
