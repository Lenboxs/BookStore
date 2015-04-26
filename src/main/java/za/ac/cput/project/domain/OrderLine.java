package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderLineNumber;
    private int quantityBought;
    private double unitPrice;

    private OrderLine(){}

    public OrderLine(Builder builder) {
        orderLineNumber=builder.orderLineNumber;
        quantityBought=builder.quantityBought;
        unitPrice=builder.unitPrice;
    }

    public Long getOrderLineNumber() {
        return orderLineNumber;
    }

    public int getQuantityBought() {
        return quantityBought;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public static class Builder{
        private Long orderLineNumber;
        private int quantityBought;
        private double unitPrice;

        public Builder(Long orderLineNumber){
            this.orderLineNumber=orderLineNumber;
        }

        public Builder quantityBought(int value){

            this.quantityBought=value;
            return this;
        }

        public Builder unitPrice(double value){
            this.unitPrice=value;
            return this;
        }

        public Builder copy(OrderLine value){
            this.orderLineNumber=value.getOrderLineNumber();
            this.quantityBought=value.getQuantityBought();
            this.unitPrice=value.getUnitPrice();
            return this;
        }

        public OrderLine build(){
            return new OrderLine(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderLine)) return false;

        OrderLine orderLine = (OrderLine) o;

        if (quantityBought != orderLine.quantityBought) return false;
        if (Double.compare(orderLine.unitPrice, unitPrice) != 0) return false;
        if (orderLineNumber != null ? !orderLineNumber.equals(orderLine.orderLineNumber) : orderLine.orderLineNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderLineNumber != null ? orderLineNumber.hashCode() : 0;
        result = 31 * result + quantityBought;
        temp = Double.doubleToLongBits(unitPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineNumber=" + orderLineNumber +
                ", quantityBought=" + quantityBought +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
