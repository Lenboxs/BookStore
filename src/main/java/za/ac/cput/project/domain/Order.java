package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Date orderDate;
    private double orderPayment;
    @Column(unique = true)
    private Long clientId;
    @Column(unique = true)
    private Long orderLineNUmber;

    public Long getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getOrderPayment() {
        return orderPayment;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getOrderLineNUmber() {
        return orderLineNUmber;
    }
}
