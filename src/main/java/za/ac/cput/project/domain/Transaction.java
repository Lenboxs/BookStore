package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String transactionCode;
    @Column
    private Long employeeId;
    private Date transactionDate;

    public String getTransactionCode() {
        return transactionCode;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}
