package com.caden.dojoOverflow.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.caden.dojoOverflow.models.Question;



@Component
public class TagValidator {

    public boolean supports(Class<?> clazz) {
        return Question.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        Question question = (Question) target;    
        String[] tags = question.getTags().split(", ");
        if(tags.length > 3) {
        	errors.rejectValue("tags", "too Many", "only 3 tags allowed per answer");
        	
        }
        
    }
}
