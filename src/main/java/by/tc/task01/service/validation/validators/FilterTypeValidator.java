package by.tc.task01.service.validation.validators;

import by.tc.task01.entity.enums.FilterType;
import by.tc.task01.service.validation.ValueValidator;

public class FilterTypeValidator implements ValueValidator {
    @Override
    public boolean validate(Object obj) {
        try{
            FilterType.valueOf((String) obj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
