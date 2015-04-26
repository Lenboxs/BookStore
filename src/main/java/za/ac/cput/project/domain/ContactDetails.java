package za.ac.cput.project.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Embeddable
public class ContactDetails implements Serializable {

    private Long employeeCellNumber;
    private String employeeEmail;
    private String employeeAddress;

    private ContactDetails() {
    }

    public Long getEmployeeCellNumber() {
        return employeeCellNumber;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public ContactDetails(Builder builder){
        employeeCellNumber=builder.employeeCellNumber;
        employeeEmail=builder.employeeEmail;
        employeeAddress=builder.employeeAddress;
    }

    public static class Builder{
        private Long employeeCellNumber;
        private String employeeEmail;
        private String employeeAddress;

        public Builder(Long employeeCellNumber) {
            this.employeeCellNumber = employeeCellNumber;
        }

        public Builder employeeEmail(String value){
            this.employeeEmail=value;
            return this;
        }

        public Builder employeeAddress(String value){
            this.employeeAddress=value;
            return this;

        }

        public ContactDetails build(){
            return new ContactDetails(this);
        }
    }

}
