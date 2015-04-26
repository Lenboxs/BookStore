package za.ac.cput.project.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/04/17.
 */
@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    @Embedded
    private Name name;
    @Embedded
    private Demographic demographic;
    @Embedded
    private ContactDetails contactDetails;
    @OneToMany
    @JoinColumn(name="employeeId")
    private List<Transaction> transaction = new ArrayList<Transaction>();

    private Employee(){};

    public Employee(Builder builder){
        employeeId=builder.employeeId;
        name=builder.name;
        demographic=builder.demographic;
        contactDetails=builder.contactDetails;
        transaction=builder.transaction;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Name getName() {
        return name;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public static class Builder{

        private Long employeeId;
        private Name name;
        private Demographic demographic;
        private ContactDetails contactDetails;
        private List<Transaction> transaction = new ArrayList<Transaction>();

        public Builder(Long employeeId){
            this.employeeId=employeeId;
        }

        public Builder name(Name value){
            this.name=value;
            return this;
        }

        public Builder demographic(Demographic value){
            this.demographic=value;
            return this;
        }

        public Builder contactDetails(ContactDetails value){
            this.contactDetails=value;
            return this;
        }

        public Builder transaction(List<Transaction> value){
            this.transaction=value;
            return this;
        }

        public Builder copy(Employee value){

            this.employeeId=value.getEmployeeId();
            this.name=value.getName();
            this.contactDetails=value.getContactDetails();
            this.demographic=value.getDemographic();
            this.transaction=value.getTransaction();
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (contactDetails != null ? !contactDetails.equals(employee.contactDetails) : employee.contactDetails != null)
            return false;
        if (demographic != null ? !demographic.equals(employee.demographic) : employee.demographic != null)
            return false;
        if (employeeId != null ? !employeeId.equals(employee.employeeId) : employee.employeeId != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (transaction != null ? !transaction.equals(employee.transaction) : employee.transaction != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId != null ? employeeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (demographic != null ? demographic.hashCode() : 0);
        result = 31 * result + (contactDetails != null ? contactDetails.hashCode() : 0);
        result = 31 * result + (transaction != null ? transaction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name=" + name +
                ", demographic=" + demographic +
                ", contactDetails=" + contactDetails +
                ", transaction=" + transaction +
                '}';
    }
}
