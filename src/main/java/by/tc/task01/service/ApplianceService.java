package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

/**
 * Interface of an appliance service
 */
public interface ApplianceService {

	/**
	 * Validates criteria and finds all the appliances
	 * that match all given criteria
	 * @param criteria criteria to match for
	 * @return appliance array that matched the criteria or null if criteria is invalid
	 */
	Appliance find(Criteria criteria);
	
}
