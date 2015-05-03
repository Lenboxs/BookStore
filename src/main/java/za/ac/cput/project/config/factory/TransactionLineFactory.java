package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.TransactionLine;

/**
 * Created by student on 2015/04/26.
 */
public class TransactionLineFactory {

    public static TransactionLine createTransactionLine(long transactionLineCode,
                                                        double transactionLinePrice,
                                                        int transactionLineQuantitySold) {

        TransactionLine transactionLine = new TransactionLine.Builder(transactionLineCode)
                .transactionLinePrice(transactionLinePrice)
                .transactionLineQuantitySold(transactionLineQuantitySold)
                .build();

        return transactionLine;
    }
}
