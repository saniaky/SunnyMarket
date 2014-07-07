package com.market.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by saniaky on 7/3/14.
 */
@Component
public class AdValidator implements Validator{

    private final long MAX_SIZE = 5 * 1024 * 1025;

    @Override
    public boolean supports(Class<?> aClass) {
        return AdDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        AdDTO form = (AdDTO)obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "label.ad.title.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "label.ad.text.required");
        for (MultipartFile images : form.getImages()) {
            if (images.getSize() > MAX_SIZE) {
                errors.rejectValue("images", "label.images.too.big");
            }
        }
    }

}
