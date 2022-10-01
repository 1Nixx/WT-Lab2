package by.tc.task01.dao.creator;

import by.tc.task01.dao.creator.creators.*;

import java.util.HashMap;
import java.util.Map;

public class ApplianceCreatorFactory {

    private static final ApplianceCreatorFactory instance = new ApplianceCreatorFactory();

    private Map<String, ApplianceCreator> creators = new HashMap<>();

    private ApplianceCreatorFactory() {
        creators.put("Oven", new OvenCreator());
        creators.put("Laptop", new LaptopCreator());
        creators.put("Refrigerator", new RefrigeratorCreator());
        creators.put("VacuumCleaner", new VacuumCleanerCreator());
        creators.put("TabletPC", new TabletPCCreator());
        creators.put("Speakers", new SpeakersCreator() );
    }

    public static ApplianceCreatorFactory getInstance() {
        return instance;
    }

    public ApplianceCreator getCreator(String applianceName) {
        return creators.get(applianceName);
    }
}
