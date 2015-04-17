package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bookCode;
    private String bookName;
    private String bookAuther;
    private String bookPublisher;
    private double bookPrice;
    private int bookquantity;

    private Book(){}

    public Book(Builder builder) {
        bookCode=builder.bookCode;
        bookName=builder.bookName;
        bookAuther=builder.bookAuther;
        bookPublisher=builder.bookPublisher;
        bookPrice=builder.bookPrice;
        bookquantity=builder.bookquantity;

    }
    public String getBookCode() {
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

    public int getBookquantity() {
        return bookquantity;
    }

    public static class Builder {
        private String bookCode;
        private String bookName;
        private String bookAuther;
        private String bookPublisher;
        private double bookPrice;
        private int bookquantity;

        public Builder(String bookName) {
            this.bookName = bookName;
        }

        public Builder bookAuther(String value){
            this.bookAuther=value;
            return this;
        }

        public Builder bookPublisher(String value)
        {
            this.bookPublisher=value;
            return this;
        }
        public Builder bookPrice(double value)
        {
            this.bookPrice=value;
            return this;
        }

        public Builder bookquantity(int value)
        {
            this.bookquantity=value;
            return this;
        }

        public Builder bookCode(String value)
        {
            this.bookCode=value;
            return this;
        }


        public Book Build(){
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
