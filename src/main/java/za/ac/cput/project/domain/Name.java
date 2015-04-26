package za.ac.cput.project.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/17.
 */
@Embeddable
public class Name implements Serializable {

    private String employeeName;
    private String employeeSurname;

    private Name() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }


    public Name(Builder builder){
        employeeName=builder.employeeName;
        employeeSurname=builder.employeeSurname;
    }

    public static class Builder{
        private String employeeName;
        private String employeeSurname;

        public Builder(String employeeName) {
            this.employeeName = employeeName;
        }

        public Builder employeeSurname(String value){
            this.employeeSurname=value;
            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }
}
