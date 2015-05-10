package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Transaction;
import za.ac.cput.project.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class TransactionServiceImpl {


    @Autowired
    TransactionRepository repository;
    public List<Transaction> getBooks() {
        List<Transaction> allTransactions = new ArrayList<Transaction>();

        Iterable<Transaction> transactions = repository.findAll();
        for (Transaction transaction : transactions) {
            allTransactions.add(transaction);
        }
        return allTransactions;
    }

}
