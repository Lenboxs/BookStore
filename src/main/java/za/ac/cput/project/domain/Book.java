package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookCode;
    private String bookName;
    private String bookAuther;
    private String bookPublisher;
    private double bookPrice;
    private int bookQuantity;
    @OneToMany
    @JoinColumn(name = "bookCode")
    private List<OrderLine> orderLine = new ArrayList<OrderLine>();
    @OneToMany
    @JoinColumn(name = "bookCode")
    private List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
    @OneToMany
    @JoinColumn(name = "bookCode")
    private List<SupplierInvoice> supplierInvoice = new ArrayList<SupplierInvoice>();

    private Book(){}

    public Book(Builder builder) {
        bookCode=builder.bookCode;
        bookName=builder.bookName;
        bookAuther=builder.bookAuther;
        bookPublisher=builder.bookPublisher;
        bookPrice=builder.bookPrice;
        bookQuantity=builder.bookQuantity;
        orderLine=builder.orderLine;
        transactionLine=builder.transactionLine;
        supplierInvoice=builder.supplierInvoice;

    }

    public Long getBookCode() {
        return bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuther() {
        return bookAuther;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public List<TransactionLine> getTransactionLine() {
        return transactionLine;
    }

    public List<SupplierInvoice> getSupplierInvoice() {
        return supplierInvoice;
    }

    public static class Builder {
        private Long bookCode;
        private String bookName;
        private String bookAuther;
        private String bookPublisher;
        private double bookPrice;
        private int bookQuantity;
        private List<OrderLine> orderLine = new ArrayList<OrderLine>();
        private List<TransactionLine> transactionLine = new ArrayList<TransactionLine>();
        private List<SupplierInvoice> supplierInvoice = new ArrayList<SupplierInvoice>();


        public Builder(Long bookCode){
            this.bookCode = bookCode;
        }

        public Builder bookAuther(String value){
            this.bookAuther=value;
            return this;
        }
        public Builder bookPublisher(String value) {
            this.bookPublisher=value;
            return this;
        }
        public Builder bookPrice(double value) {
            this.bookPrice=value;
            return this;
        }
        public Builder bookQuantity(int value) {
            this.bookQuantity=value;
            return this;
        }
        public Builder bookName(String value) {
            this.bookName=value;
            return this;
        }
        public Builder orderLine(List<OrderLine> value) {
            this.orderLine=value;
            return this;
        }
        public Builder transactionLine(List<TransactionLine> value) {
            this.transactionLine=value;
            return this;
        }
        public Builder supplierInvoice(List<SupplierInvoice> value) {
            this.supplierInvoice=value;
            return this;
        }

        public Builder copy(Book value){

            this.bookCode=value.getBookCode();
            this.bookName=value.getBookName();
            this.bookAuther=value.getBookAuther();
            this.bookPublisher=value.getBookPublisher();
            this.bookPrice=value.getBookPrice();
            this.bookQuantity=value.getBookQuantity();
            this.orderLine=value.getOrderLine();
            this.transactionLine=value.getTransactionLine();
            this.supplierInvoice=value.getSupplierInvoice();
            return this;
        }

        public Book build(){
            return new Book(this);
        }


    }

    @Override
    public int hashCode() {
        return bookCode != null ? bookCode.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        return !(bookCode != null ? !bookCode.equals(book.bookCode) : book.bookCode != null);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
