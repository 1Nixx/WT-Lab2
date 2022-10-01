package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * The Criteria class represents search criteria
 * on a single field of an appliance. It consists of
 * the criteria itself (field), search type (either EQUALS,
 * LESS THAN or GREATER THAN) and the value to compare with
 */
public class Criteria {

	/**
	 * Backing field of search type
	 */
	private String groupSearchName;

	/**
	 * Backing field of search criteria
	 */
	private Map<String, Object> criteria = new HashMap<String, Object>();

	/**
	 * Instantiates object of a type Criteria
	 *
	 * @param groupSearchName search type
	 */
	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	/**
	 * Gets the search type
	 *
	 * @return search type
	 */
	public String getGroupSearchName() {
		return groupSearchName;
	}

	/**
	 * Gets the search criteria
	 *
	 * @return search criteria
	 */
	public Map<String, Object> getSearchCriteria() {
		return criteria;
	}

	/**
	 * Add new search criteria
	 * @param searchCriteria field to search
	 * @param value searchCriteria value
	 */
	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

}
