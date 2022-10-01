package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

/**
 * Interface of an appliance dao class
 */
public interface ApplianceDAO {
	/**
	 * Finds all the appliances that match the given criteria
	 *
	 * @param criteria criteria that shall be matched in an appliance
	 * @return array of appliances that match the criteria or null is criteria is invalid
	 */
	Appliance find(Criteria criteria);
}
