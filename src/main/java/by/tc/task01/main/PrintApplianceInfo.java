package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

/**
 * Helper class of printing laboratory work results
 */
public class PrintApplianceInfo {

	/**
	 * Prints the information about all found appliances.
	 * If array is empty "No appliances found" is printed.
	 * If object is null "Find error" is printed
	 * @param appliance return value appliance service find method
	 */
	public static void print(Appliance appliance) {
		if (appliance == null)
			System.out.println("Find error");
		else
			System.out.println(appliance.toString());
	}
}
