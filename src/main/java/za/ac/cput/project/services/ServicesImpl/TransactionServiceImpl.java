package za.ac.cput.project.services.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.domain.Transaction;
import za.ac.cput.project.domain.TransactionLine;
import za.ac.cput.project.repository.TransactionRepository;
import za.ac.cput.project.services.TransactionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/10.
 */
@Service
public class TransactionServiceImpl implements TransactionService{


    @Autowired
    TransactionRepository repository;
    public List<Transaction> getTransaction() {
        List<Transaction> allTransactions = new ArrayList<Transaction>();

        Iterable<Transaction> transactions = repository.findAll();
        for (Transaction transaction : transactions) {
            allTransactions.add(transaction);
        }
        return allTransactions;
    }

    @Override
    public List<TransactionLine> getTransactionLine(Long id) {
        return repository.findOne(id).getTransactionLine();
    }


}
