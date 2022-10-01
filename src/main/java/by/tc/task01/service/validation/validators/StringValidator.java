package by.tc.task01.service.validation.validators;

import by.tc.task01.entity.enums.FilterType;
import by.tc.task01.service.validation.ValueValidator;

public class StringValidator implements ValueValidator {

    @Override
    public boolean validate(Object obj) {
        try{
            if (((String) obj).length() == 0 || ((String) obj).equals(""))
                return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
