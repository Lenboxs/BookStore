package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class TransactionLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String transactionLineCode;
    private double transactionLinePrice;
    private int transactionLineQuantitySold;
    @Column(unique = true)
    private String bookCode;
    @Column(unique = true)
    private String transactionCode;

    public String getTransactionLineCode() {
        return transactionLineCode;
    }

    public double getTransactionLinePrice() {
        return transactionLinePrice;
    }

    public int getTransactionLineQuantitySold() {
        return transactionLineQuantitySold;
    }

    public String getBookCode() {
        return bookCode;
    }

    public String getTransactionCode() {
        return transactionCode;
    }
}
