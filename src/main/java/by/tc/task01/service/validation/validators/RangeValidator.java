package by.tc.task01.service.validation.validators;

import by.tc.task01.entity.enums.FilterType;
import by.tc.task01.service.validation.ValueValidator;

public class RangeValidator implements ValueValidator {
    @Override
    public boolean validate(Object obj) {
        try{
            String range = (String) obj;
            String[] ind = range.split("-");
            if (ind.length != 2)
                return false;
            for (int i = 0; i < ind.length; i++)
                if (Double.parseDouble(ind[i]) < 0)
                    return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
