package by.tc.task01.service.validation.validators;

import by.tc.task01.entity.enums.FilterType;
import by.tc.task01.service.validation.ValueValidator;

public class DoubleValidator implements ValueValidator {

    @Override
    public boolean validate(Object obj) {
        try {

            return Double.parseDouble(String.valueOf(obj)) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
