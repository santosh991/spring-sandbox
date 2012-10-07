package net.agilegeeks.rest.accounts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

  private static final Logger log = LoggerFactory.getLogger(PersonValidator.class);

  @Override public boolean supports(Class<?> clazz) {
    return ClassUtils.isAssignable(clazz, Person.class);
  }

  @Override public void validate(Object target, Errors errors) {
    Person p = (Person) target;
    log.debug("validating Person " + p);
    ValidationUtils.rejectIfEmpty(errors, "name", "field.name.required", "Field 'name' cannot be blank.");
  }

}
