package za.ac.cput.project.domain;

import sun.font.TrueTypeFont;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Date orderDate;
    private double orederPayment;
    @Column(unique = true)
    private Long clientId;
    @Column(unique = true)
    private Long orderLineNumber;

    public Long getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getOrederPayment() {
        return orederPayment;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getOrderLineNumber() {
        return orderLineNumber;
    }
}
