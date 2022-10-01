package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
		if (criteria == null ||
				criteria.getSearchCriteria() == null)
			return false;

		for (Map.Entry<String, Object> entry : criteria.getSearchCriteria().entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			ValueValidator validator = ValueValidatorFactory.getInstance().getValidator(key);
			boolean isValid = true;
			isValid = validator.validate(value);
			if (!isValid)
				return false;
		}

		return true;
	}

}