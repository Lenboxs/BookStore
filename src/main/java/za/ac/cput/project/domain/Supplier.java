package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private String supplierAddress;
    @OneToMany
    @JoinColumn(name="supplierId")
    private List<SupplierInvoice> supplierInvoice = new ArrayList<SupplierInvoice>();


    private Supplier(){}

    public Supplier(Builder builder){

        supplierId=builder.supplierId;
        supplierName=builder.supplierName;
        supplierContactDetails=builder.supplierContactDetails;
        supplierEmail=builder.supplierEmail;
        supplierAddress=builder.supplierAddress;
        supplierInvoice=builder.supplierInvoice;

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

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public List<SupplierInvoice> getSupplierInvoice() {
        return supplierInvoice;
    }


    public static class Builder{

        private long supplierId;
        private String supplierName;
        private long supplierContactDetails;
        private String supplierEmail;
        private String supplierAddress;
        private List<SupplierInvoice> supplierInvoice = new ArrayList<SupplierInvoice>();

        public Builder(Long value){
            this.supplierId=value;
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
        public Builder supplierAddress(String value){
            this.supplierAddress=value;
            return this;
        }
        public Builder supplierInvoice(List<SupplierInvoice> value){
            this.supplierInvoice=value;
            return this;
        }

        public Builder copy(Supplier value){
            this.supplierId=value.getSupplierId();
            this.supplierName=value.getSupplierName();
            this.supplierContactDetails=value.getSupplierContactDetails();
            this.supplierEmail=value.getSupplierEmail();
            this.supplierAddress=value.getSupplierAddress();
            this.supplierInvoice=value.getSupplierInvoice();
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supplier)) return false;

        Supplier supplier = (Supplier) o;

        if (supplierAddress != null ? !supplierAddress.equals(supplier.supplierAddress) : supplier.supplierAddress != null)
            return false;
        if (supplierContactDetails != null ? !supplierContactDetails.equals(supplier.supplierContactDetails) : supplier.supplierContactDetails != null)
            return false;
        if (supplierEmail != null ? !supplierEmail.equals(supplier.supplierEmail) : supplier.supplierEmail != null)
            return false;
        if (supplierId != null ? !supplierId.equals(supplier.supplierId) : supplier.supplierId != null) return false;
        if (supplierInvoice != null ? !supplierInvoice.equals(supplier.supplierInvoice) : supplier.supplierInvoice != null)
            return false;
        if (supplierName != null ? !supplierName.equals(supplier.supplierName) : supplier.supplierName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = supplierId != null ? supplierId.hashCode() : 0;
        result = 31 * result + (supplierName != null ? supplierName.hashCode() : 0);
        result = 31 * result + (supplierContactDetails != null ? supplierContactDetails.hashCode() : 0);
        result = 31 * result + (supplierEmail != null ? supplierEmail.hashCode() : 0);
        result = 31 * result + (supplierAddress != null ? supplierAddress.hashCode() : 0);
        result = 31 * result + (supplierInvoice != null ? supplierInvoice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", supplierContactDetails=" + supplierContactDetails +
                ", supplierEmail='" + supplierEmail + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierInvoice=" + supplierInvoice +
                '}';
    }
}
