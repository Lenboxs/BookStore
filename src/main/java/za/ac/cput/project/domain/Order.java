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
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Date orderDate;
    private double orderPayment;
    @OneToMany
    @JoinColumn(name="orderId")
    private List<OrderLine> orderLine = new ArrayList<OrderLine>();

    private Order(){}

    public Order(Builder builder) {
        orderId=builder.orderId;
        orderDate=builder.orderDate;
        orderPayment=builder.orderPayment;
        orderLine=builder.orderLine;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getOrderPayment() {
        return orderPayment;
    }

    public List<OrderLine> getOrderLine() {
        return orderLine;
    }

    public static class Builder{
        private Long orderId;
        private Date orderDate;
        private double orderPayment;
        private List<OrderLine> orderLine = new ArrayList<OrderLine>();

        public Builder(Long orderId){
            this.orderId=orderId;
        }
        public Builder orderDate(Date value){
            this.orderDate=value;
            return this;
        }
        public Builder orderPayment(double value){
            this.orderPayment=value;
            return this;
        }
        public Builder orderLine(List<OrderLine> value){
            this.orderLine=value;
            return this;
        }

        public Builder copy(Order value){

            this.orderId=value.getOrderId();
            this.orderDate=value.getOrderDate();
            this.orderPayment=value.getOrderPayment();
            this.orderLine=value.getOrderLine();
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }

}
