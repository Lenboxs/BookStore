package za.ac.cput.project.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by student on 2015/04/17.
 */
@Embeddable
public class Demographic implements Serializable {

    private String rase;
    private String gender;
    private Date dateOfBirth;

    public Demographic() {
    }

    public String getRase() {
        return rase;
    }

    public String getGender() {
        return gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Demographic(Builder builder){
        rase=builder.rase;
        gender=builder.gender;
        dateOfBirth=builder.dateOfBirth;
    }

    public static class Builder{
        private String rase;
        private String gender;
        private Date dateOfBirth;

        public Builder(String rase) {
            this.rase = rase;
        }

        public Builder gender(String value){
            this.gender=value;
            return this;
        }

        public Builder dateOfBirth(Date value){
            this.dateOfBirth=value;
            return this;

        }

        public Demographic build(){
            return new Demographic(this);
        }
    }

}
