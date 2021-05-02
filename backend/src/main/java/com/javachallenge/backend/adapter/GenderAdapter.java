package com.javachallenge.backend.adapter;

import com.javachallenge.backend.enumerator.GenderEnum;
import com.javachallenge.backend.model.Person;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class GenderAdapter {

    public void convertGenderIdentifierToDescription(List<Person> persons) {
        if (persons != null && !persons.isEmpty()) {
            for (Person person : persons) {
                for (GenderEnum value : GenderEnum.values()) {
                    if (person.getGender().equalsIgnoreCase(value.getIdentifier())) {
                        person.setGender(value.getDescription());
                    }
                }
            }
        }
    }

    public void convertGenderDescriptionToIdentifier(List<Person> persons) {
        if (persons != null && !persons.isEmpty()) {
            for (Person person : persons) {
                for (GenderEnum value : GenderEnum.values()) {
                    if (person.getGender().equalsIgnoreCase(value.getDescription())) {
                        person.setGender(value.getIdentifier());
                    }
                }
            }
        }
    }
}
