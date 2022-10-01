package by.tc.task01.entity;

/**
 * Represents a single object of appliance of the shop
 */
public abstract class Appliance {

    /**
     * Returns true if appliance matches the given search criteria.
     * Method should be overridden in child class
     *
     * @param key field to match for
     * @param value value of field
     * @return true if appliance matches the given criteria, false otherwise
     */
    public abstract boolean matches(String key, Object value);
}
