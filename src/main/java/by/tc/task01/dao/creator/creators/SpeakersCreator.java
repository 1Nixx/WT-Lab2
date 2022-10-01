package by.tc.task01.dao.creator.creators;

import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;

public class SpeakersCreator implements ApplianceCreator {
    private static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    private static final String NUMBER_OF_SPEAKERS = "NUMBER_OF_SPEAKERS";
    private static final String FREQUENCY_RANGE = "FREQUENCY_RANGE";
    private static final String CORD_LENGTH = "CORD_LENGTH";

    @Override
    public Appliance create(String values) {
        String[] criterias = values.split(", ");

        Speakers speakers = new Speakers();

        for (String attribute: criterias) {
            String[] attrValue = attribute.split("=");

            switch (attrValue[0]) {
                case POWER_CONSUMPTION-> speakers.powerConsumption = Integer.parseInt(attrValue[1]);
                case NUMBER_OF_SPEAKERS -> speakers.numberOfSpeakers = Integer.parseInt(attrValue[1]);
                case FREQUENCY_RANGE -> speakers.frequencyRange = attrValue[1];
                case CORD_LENGTH -> speakers.cordLength = Integer.parseInt(attrValue[1]);
                default -> throw new IllegalArgumentException("No such appliance exists");
            }
        }
        return speakers;
    }
}
