package by.tc.task01.dao.creator.creators;

import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;

/**
 * Represents creator of a refrigerator appliance
 */
public class RefrigeratorCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String WEIGHT = "WEIGHT";
    private static final String FREEZER_CAPACITY = "FREEZER_CAPACITY";
    private static final String OVERALL_CAPACITY = "OVERALL_CAPACITY";
    private static final String HEIGHT = "HEIGHT";
    private static final String WIDTH = "WIDTH";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(String values) {
        String[] criterias = values.split(", ");

        Refrigerator refrigerator = new Refrigerator();

        for (String attribute: criterias) {
            String[] attrValue = attribute.split("=");

            switch (attrValue[0]) {
                case POWER_CONSUMPTION-> refrigerator.powerConsumption = Integer.parseInt(attrValue[1]);
                case WEIGHT -> refrigerator.weight = Integer.parseInt(attrValue[1]);
                case FREEZER_CAPACITY -> refrigerator.freezerCapacity = Integer.parseInt(attrValue[1]);
                case OVERALL_CAPACITY -> refrigerator.overallCapacity = Integer.parseInt(attrValue[1]);
                case HEIGHT -> refrigerator.height = Double.parseDouble(attrValue[1]);
                case WIDTH -> refrigerator.width = Double.parseDouble(attrValue[1]);
                default -> throw new IllegalArgumentException("No such appliance exists");
            }
        }
        return refrigerator;
    }
}
