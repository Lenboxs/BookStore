package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.ContactDetails;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class ContactDetailsFactory {

    public static ContactDetails createContactDetails(Long employeeCellNumber, Map<String, String> value){

        ContactDetails contactDetails = new ContactDetails
                .Builder(employeeCellNumber)
                .employeeAddress(value.get("employeeAddress"))
                .employeeEmail(value.get("employeeEmail"))
                .build();

        return contactDetails;

    }
}
