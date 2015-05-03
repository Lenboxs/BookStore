package za.ac.cput.project.config.factory;

import za.ac.cput.project.domain.Demographic;

import java.util.Date;
import java.util.Map;

/**
 * Created by student on 2015/05/03.
 */
public class DemographicFactory {

    public static Demographic createDemographic(Map<String, String> value, Date dateOfBirth ) {
        Demographic demographic = new Demographic
                .Builder(value.get("race"))
                .gender(value.get("gender"))
                .dateOfBirth(dateOfBirth)
                .build();
        return demographic;
    }

    }
