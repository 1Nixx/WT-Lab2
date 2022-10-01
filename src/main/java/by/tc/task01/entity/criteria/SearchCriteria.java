package by.tc.task01.entity.criteria;

/**
 * Encapsulates all constants associated with search criteria
 */
public final class SearchCriteria {

	/**
	 * Searches by oven fields
	 */
	public static enum Oven{
		POWER_CONSUMPTION, WEIGHT, CAPACITY, DEPTH, HEIGHT, WIDTH
	}

	/**
	 * Searches by Laptop fields
	 */
	public static enum Laptop{
		BATTERY_CAPACITY, OS, MEMORY_ROM, SYSTEM_MEMORY, CPU, DISPLAY_INCHS
	}

	/**
	 * Searches by Refrigerator fields
	 */
	public static enum Refrigerator{
		POWER_CONSUMPTION, WEIGHT, FREEZER_CAPACITY, OVERALL_CAPACITY, HEIGHT, WIDTH
	}

	/**
	 * Searches by VacuumCleaner fields
	 */
	public static enum VacuumCleaner{
		POWER_CONSUMPTION, FILTER_TYPE, BAG_TYPE, WAND_TYPE, MOTOR_SPEED_REGULATION, CLEANING_WIDTH
	}

	/**
	 * Searches by TabletPC fields
	 */
	public static enum TabletPC{
		BATTERY_CAPACITY, DISPLAY_INCHES, MEMORY_ROM, FLASH_MEMORY_CAPACITY, COLOR		
	}

	/**
	 * Searches by Speakers fields
	 */
	public static enum Speakers{
		POWER_CONSUMPTION, NUMBER_OF_SPEAKERS, FREQUENCY_RANGE, CORD_LENGTH
	}

	/**
	 * Private constructor to remove the ability of instantiating search criteria
	 */
	private SearchCriteria() {}
}

