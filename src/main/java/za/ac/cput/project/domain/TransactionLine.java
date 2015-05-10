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
    private Long transactionLineCode;
    private double transactionLinePrice;
    private int transactionLineQuantitySold;

    private TransactionLine(){}

    public TransactionLine(Builder builder) {
        transactionLineCode=builder.transactionLineCode;
        transactionLinePrice=builder.transactionLinePrice;
        transactionLineQuantitySold=builder.transactionLineQuantitySold;
    }

    public Long getTransactionLineCode() {
        return transactionLineCode;
    }

    public double getTransactionLinePrice() {
        return transactionLinePrice;
    }

    public int getTransactionLineQuantitySold() {
        return transactionLineQuantitySold;
    }

    public static class Builder{

        private Long transactionLineCode;
        private double transactionLinePrice;
        private int transactionLineQuantitySold;

        public Builder(Long transactionLineCode){
            this.transactionLineCode=transactionLineCode;
        }

        public Builder transactionLinePrice(double value){
            this.transactionLinePrice=value;
            return this;
        }

        public Builder transactionLineQuantitySold(int value){
            this.transactionLineQuantitySold=value;
            return this;
        }

        public Builder copy(TransactionLine value){
            this.transactionLineCode=value.getTransactionLineCode();
            this.transactionLinePrice=value.getTransactionLinePrice();
            this.transactionLineQuantitySold=value.getTransactionLineQuantitySold();
            return this;
        }
        public TransactionLine build(){
            return new TransactionLine(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionLine)) return false;

        TransactionLine that = (TransactionLine) o;

        if (transactionLineCode != that.transactionLineCode) return false;
        if (Double.compare(that.transactionLinePrice, transactionLinePrice) != 0) return false;
        if (transactionLineQuantitySold != that.transactionLineQuantitySold) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return transactionLineCode != null ? transactionLineCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "TransactionLine{" +
                "transactionLineCode='" + transactionLineCode + '\'' +
                ", transactionLinePrice=" + transactionLinePrice +
                ", transactionLineQuantitySold=" + transactionLineQuantitySold +
                '}';
    }
}
