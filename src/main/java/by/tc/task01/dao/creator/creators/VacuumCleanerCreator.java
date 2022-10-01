package by.tc.task01.dao.creator.creators;

import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.enums.FilterType;

/**
 * Represents creator of a vacuum cleaner appliance
 */
public class VacuumCleanerCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String FILTER_TYPE = "FILTER_TYPE";
    private static final String BAG_TYPE = "BAG_TYPE";
    private static final String WAND_TYPE = "WAND_TYPE";
    private static final String MOTOR_SPEED_REGULATION = "MOTOR_SPEED_REGULATION";
    private static final String CLEANING_WIDTH = "CLEANING_WIDTH";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(String values) {
        String[] criterias = values.split(", ");

        VacuumCleaner vacuumCleaner = new VacuumCleaner();

        for (String attribute: criterias) {
            String[] attrValue = attribute.split("=");

            switch (attrValue[0]) {
                case POWER_CONSUMPTION-> vacuumCleaner.powerConsumption = Integer.parseInt(attrValue[1]);
                case FILTER_TYPE -> vacuumCleaner.filterType = FilterType.valueOf(attrValue[1].toUpperCase());
                case BAG_TYPE -> vacuumCleaner.bagType = attrValue[1];
                case WAND_TYPE -> vacuumCleaner.wandType = attrValue[1];
                case MOTOR_SPEED_REGULATION -> vacuumCleaner.motorSpeedRegulation = Integer.parseInt(attrValue[1]);
                case CLEANING_WIDTH -> vacuumCleaner.cleaningWidth = Integer.parseInt(attrValue[1]);
                default -> throw new IllegalArgumentException("No such appliance exists");
            }
        }
        return vacuumCleaner;
    }
}
