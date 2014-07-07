package com.market.dto;

import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by saniaky on 7/2/14.
 */
@Component
public class SignupValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return SignupDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SignupDTO signupDTO = (SignupDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "label.field.username.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "label.field.password.empty");

        String name = signupDTO.getUsername();
        if (name.length() > 100) {
            errors.rejectValue("username", "label.field.username.long");
        }

        if (userService.isUserExist(name)) {
            errors.rejectValue("username", "label.field.username.exist");
        }

        if (!signupDTO.getPassword().equals(signupDTO.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "label.field.password.mismatch");
        }

    }
}
