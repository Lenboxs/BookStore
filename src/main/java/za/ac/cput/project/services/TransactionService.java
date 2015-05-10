package za.ac.cput.project.services;

import za.ac.cput.project.domain.Transaction;

import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
public interface TransactionService {
    List<Transaction> getTransactions();
}
