package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Supplier implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierId;
    private String supplierName;
    private Long supplierContactDetails;
    private String supplierEmail;
    private String supplieraddress;

    private Supplier(){}

    public Supplier(Builder builder){

        supplierId=builder.supplierId;
        supplierName=builder.supplierName;
        supplierContactDetails=builder.supplierContactDetails;
        supplierEmail=builder.supplierEmail;
        supplieraddress=builder.supplieraddress;

    }

    public Long getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public Long getSupplierContactDetails() {
        return supplierContactDetails;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public String getSupplieraddress() {
        return supplieraddress;
    }

    public static class Builder{

        private long supplierId;
        private String supplierName;
        private long supplierContactDetails;
        private String supplierEmail;
        private String supplieraddress;

        public Builder supplierId(Long value){
            this.supplierId=value;
            return this;
        }
        public Builder supplierName(String value){
            this.supplierName=value;
            return this;
        }
        public Builder supplierContactDetails(long value){
            this.supplierContactDetails=value;
            return this;
        }
        public Builder supplierEmail(String value){
            this.supplierEmail=value;
            return this;
        }
        public Builder supplieraddress(String value){
            this.supplieraddress=value;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }

    }

    @Override
    public int hashCode() {
        return supplierId != null ? supplierId.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;

        Supplier supplier = (Supplier) o;

        return !(supplierId != null ? !supplierId.equals(supplier.supplierId) : supplier.supplierId != null);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
