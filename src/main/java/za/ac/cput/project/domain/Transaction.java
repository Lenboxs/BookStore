
package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionCode;
    private Date transactionDate;
    @OneToMany
    @JoinColumn(name="transactionCode")
    private List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();

    private Transaction(){}

    public Transaction(Builder builder){

        transactionCode=builder.transactionCode;
        transactionDate=builder.transactionDate;
        transactionLine=builder.transactionLine;
    }

    public Long getTransactionCode() {
        return transactionCode;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public List<TransactionLine> getTransactionLine() {
        return transactionLine;
    }

    public static class Builder{

        private Long transactionCode;
        private Date transactionDate;
        private List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();

        public Builder(Long transactionCode){
            this.transactionCode=transactionCode;
        }

        public Builder transactionDate(Date value){
            this.transactionDate=value;
            return this;
        }

        public Builder transactionLine(List<TransactionLine> value){
            this.transactionLine=value;
            return this;
        }

        public Builder copy(Transaction value){
            this.transactionCode=value.getTransactionCode();
            this.transactionDate=value.getTransactionDate();
            this.transactionLine=value.getTransactionLine();
            return this;
        }

        public Transaction build(){
            return new Transaction(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        if (transactionCode != that.transactionCode) return false;
        if (transactionDate != null ? !transactionDate.equals(that.transactionDate) : that.transactionDate != null)
            return false;
        if (transactionLine != null ? !transactionLine.equals(that.transactionLine) : that.transactionLine != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (transactionCode ^ (transactionCode >>> 32));
        result = 31 * result + (transactionDate != null ? transactionDate.hashCode() : 0);
        result = 31 * result + (transactionLine != null ? transactionLine.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionCode='" + transactionCode + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionLine=" + transactionLine +
                '}';
    }
}
