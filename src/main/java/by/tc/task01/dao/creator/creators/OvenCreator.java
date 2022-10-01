package by.tc.task01.dao.creator.creators;

import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;

/**
 * Represents creator of a oven appliance
 */
public class OvenCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String WEIGHT = "WEIGHT";
    private static final String CAPACITY = "CAPACITY";
    private static final String DEPTH = "DEPTH";
    private static final String HEIGHT = "HEIGHT";
    private static final String WIDTH = "WIDTH";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(String values) {
        String[] criterias = values.split(", ");

        Oven oven = new Oven();

        for (String attribute: criterias) {
            String[] attrValue = attribute.split("=");

            switch (attrValue[0]) {
                case POWER_CONSUMPTION-> oven.powerConsumption = Integer.parseInt(attrValue[1]);
                case WEIGHT -> oven.weight = Integer.parseInt(attrValue[1]);
                case CAPACITY -> oven.capacity = Integer.parseInt(attrValue[1]);
                case DEPTH -> oven.depth = Integer.parseInt(attrValue[1]);
                case HEIGHT -> oven.height = Double.parseDouble(attrValue[1]);
                case WIDTH -> oven.width = Double.parseDouble(attrValue[1]);
                default -> throw new IllegalArgumentException("No such appliance exists");
            }
        }
        return oven;
    }
}
