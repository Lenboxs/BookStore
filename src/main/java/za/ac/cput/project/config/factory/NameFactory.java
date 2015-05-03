package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Name;

import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class NameFactory {

    public static Name createName(Map<String,String>value){

        Name name = new Name
                .Builder(value.get("employeeName"))
                .employeeSurname(value.get("employeeSurname"))
                .build();

        return name;
    }
}
