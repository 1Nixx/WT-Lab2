package by.tc.task01.dao.creator;

import by.tc.task01.entity.Appliance;

/**
 * Represents factory of an appliance from values
 */
public interface ApplianceCreator {
    /**
     * Creates the appliance of a correct type from
     * attributes saved in string
     * @param values string with attributes from xml file
     * @return appliance of a correct type
     */
    Appliance create(String values);
}
