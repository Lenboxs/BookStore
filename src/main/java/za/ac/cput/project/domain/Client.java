package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    private String clientName;
    private String clientSurname;
    private Long clientContactNumber;
    @OneToMany
    @JoinColumn(name = "clientId")
    private List<Order> order = new ArrayList<Order>();

    private Client(){}

    public Client(Builder builder) {
        clientId=builder.clientId;
        clientName=builder.clientName;
        clientSurname=builder.clientSurname;
        clientContactNumber=builder.clientContactNumber;
        order=builder.order;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public Long getClientContactNumber() {
        return clientContactNumber;
    }

    public List<Order> getOrder() {
        return order;
    }


    public static class Builder{

        private Long clientId;
        private String clientName;
        private String clientSurname;
        private Long clientContactNumber;
        private List<Order> order = new ArrayList<Order>();

        public Builder(Long clientId){
            this.clientId=clientId;
        }

        public Builder clientSurname(String value){
            this.clientSurname=value;
            return this;
        }

        public Builder clientContactNumber(Long value){
            this.clientContactNumber=value;
            return this;
        }

        public Builder clientName(String value){
            this.clientName=value;
            return this;
        }

        public Builder order(List<Order> value){
            this.order=value;
            return this;
        }
        public Builder copy(Client value){

            this.clientId=value.getClientId();
            this.clientName=value.getClientName();
            this.clientSurname=value.getClientSurname();
            this.clientContactNumber=value.getClientContactNumber();
            this.order=value.getOrder();
            return this;
        }

        public Client build(){
            return new Client(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (clientContactNumber != null ? !clientContactNumber.equals(client.clientContactNumber) : client.clientContactNumber != null)
            return false;
        if (clientId != null ? !clientId.equals(client.clientId) : client.clientId != null) return false;
        if (clientName != null ? !clientName.equals(client.clientName) : client.clientName != null) return false;
        if (clientSurname != null ? !clientSurname.equals(client.clientSurname) : client.clientSurname != null)
            return false;
        if (order != null ? !order.equals(client.order) : client.order != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        result = 31 * result + (clientSurname != null ? clientSurname.hashCode() : 0);
        result = 31 * result + (clientContactNumber != null ? clientContactNumber.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientSurname='" + clientSurname + '\'' +
                ", clientContactNumber=" + clientContactNumber +
                ", order=" + order +
                '}';
    }
}
