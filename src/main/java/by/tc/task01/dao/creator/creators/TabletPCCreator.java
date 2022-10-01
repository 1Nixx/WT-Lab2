package by.tc.task01.dao.creator.creators;

import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.enums.ColorType;

/**
 * Represents creator of a tabletPC appliance
 */
public class TabletPCCreator implements ApplianceCreator {
    private static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    private static final String DISPLAY_INCHES = "DISPLAY_INCHES";
    private static final String MEMORY_ROM = "MEMORY_ROM";
    private static final String FLASH_MEMORY_CAPACITY = "FLASH_MEMORY_CAPACITY";
    private static final String COLOR = "COLOR";

    /**
     * {@inheritDoc}
     */
    @Override
    public Appliance create(String values) {
        String[] criterias = values.split(", ");

        TabletPC tabletPC = new TabletPC();

        for (String attribute: criterias) {
            String[] attrValue = attribute.split("=");

            switch (attrValue[0]) {
                case BATTERY_CAPACITY-> tabletPC.batteryCapacity = Integer.parseInt(attrValue[1]);
                case DISPLAY_INCHES -> tabletPC.displayInches = Integer.parseInt(attrValue[1]);
                case MEMORY_ROM -> tabletPC.memoryRom = Integer.parseInt(attrValue[1]);
                case FLASH_MEMORY_CAPACITY -> tabletPC.flashMemoryCapacity = Integer.parseInt(attrValue[1]);
                case COLOR -> tabletPC.color = ColorType.valueOf(attrValue[1].toUpperCase());
                default -> throw new IllegalArgumentException("No such appliance exists");
            }
        }
        return tabletPC;
    }
}
