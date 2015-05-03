package za.ac.cput.project.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class SupplierInvoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long supplierInvoiceId;
    private int quantity;

    private SupplierInvoice(Builder builder){
        supplierInvoiceId=builder.supplierInvoiceId;
        quantity=builder.quantity;
    }

    public Long getSupplierInvoiceId() {
        return supplierInvoiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public static class Builder{
        private long supplierInvoiceId;
        private int quantity;

        public Builder(Long supplierInvoiceId){
            this.supplierInvoiceId=supplierInvoiceId;
        }

        public Builder quantity(int value){
            this.quantity=value;
            return this;
        }

        public Builder copy(SupplierInvoice value){
            this.supplierInvoiceId=value.getSupplierInvoiceId();
            this.quantity=value.getQuantity();
            return this;
        }
        public SupplierInvoice build(){
            return new SupplierInvoice(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierInvoice)) return false;

        SupplierInvoice that = (SupplierInvoice) o;

        if (quantity != that.quantity) return false;
        if (supplierInvoiceId != that.supplierInvoiceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (supplierInvoiceId ^ (supplierInvoiceId >>> 32));
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "SupplierInvoice{" +
                "supplierInvoiceId='" + supplierInvoiceId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
