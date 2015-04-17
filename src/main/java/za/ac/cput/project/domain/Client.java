package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;

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

    private Client(){}

    public Client(Builder builder) {
        clientId=builder.clientId;
        clientName=builder.clientName;
        clientSurname=builder.clientSurname;
        clientContactNumber=builder.clientContactNumber;
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

    public static class Builder{

        private Long clientId;
        private String clientName;
        private String clientSurname;
        private Long clientContactNumber;

        public Builder(String clientName){
            this.clientName=clientName;
        }

        public Builder clientSurname(String value){
            this.clientSurname=value;
            return this;
        }

        public Builder clientContactNumber(Long value){
            this.clientContactNumber=value;
            return this;
        }

        public Builder clientId(Long value){
            this.clientId=value;
            return this;
        }

        public Client Build(){
            return new Client(this);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
