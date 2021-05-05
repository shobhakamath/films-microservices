package com.films.model.constraints;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomDateValidator implements
    ConstraintValidator<CustomDateConstraint, LocalDateTime> {

    private static final String DATE_PATTERN = "MM/dd/yyyy";

    @Override
    public void initialize(CustomDateConstraint customDate) {
    }

    @Override
    public boolean isValid(LocalDateTime customDateField,
        ConstraintValidatorContext cxt) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        try {
            sdf.setLenient(false);
            Date d = sdf.parse(customDateField.format(formatter));
            return true;
        }
        catch (ParseException e) {
            return false;
        }
    }

}