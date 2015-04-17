package za.ac.cput.project.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class SupplierInvoice implements Serializable {

    @Column(unique = true)
    private String bookCode;
    @Column(unique = true)
    private Long supplierId;

    public String getBookCode() {
        return bookCode;
    }

    public Long getSupplierId() {
        return supplierId;
    }
}
