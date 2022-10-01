package by.tc.task01.dao.creator.creators;

import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;

public class LaptopCreator implements ApplianceCreator {

    private static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    private static final String OS = "OS";
    private static final String MEMORY_ROM = "MEMORY_ROM";
    private static final String SYSTEM_MEMORY = "SYSTEM_MEMORY";
    private static final String CPU = "CPU";
    private static final String DISPLAY_INCHS = "DISPLAY_INCHS";

    @Override
    public Appliance create(String values) {
        String[] criterias = values.split(", ");

        Laptop laptop = new Laptop();

        for (String attribute: criterias) {
            String[] attrValue = attribute.split("=");

            switch (attrValue[0]) {
                case BATTERY_CAPACITY-> laptop.batteryCapacity = Double.parseDouble(attrValue[1]);
                case OS -> laptop.os = attrValue[1];
                case MEMORY_ROM -> laptop.memoryRom = Integer.parseInt(attrValue[1]);
                case SYSTEM_MEMORY -> laptop.systemMemory = Integer.parseInt(attrValue[1]);
                case CPU -> laptop.cpu = Double.parseDouble(attrValue[1]);
                case DISPLAY_INCHS -> laptop.displayInchs = Integer.parseInt(attrValue[1]);
                default -> throw new IllegalArgumentException("No such appliance exists");
            }
        }
        return laptop;
    }
}
