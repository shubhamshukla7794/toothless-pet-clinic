package com.shubham.toothlesspetclinic.validators;

import com.shubham.toothlesspetclinic.model.Pet;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PetValidator implements Validator {
    private static final String REQUIRED = "required";

    @Override
    public void validate(Object obj, Errors errors) {
        Pet pet = (Pet) obj;
        String name = pet.getName();

        if (!StringUtils.hasLength(name)){
            errors.rejectValue("name", REQUIRED, REQUIRED);
        }

        if (pet.isNew() && pet.getPetType()==null){
            errors.rejectValue("petType", REQUIRED, REQUIRED);
        }

        if (pet.getBirthDate()==null){
            errors.rejectValue("birthDate", REQUIRED, REQUIRED);
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Pet.class.isAssignableFrom(clazz);
    }
}
