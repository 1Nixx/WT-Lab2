package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.dao.creator.ApplianceCreatorFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Implementation of an appliance dao that reads
 * the information from file in resources folder
 */
public class ApplianceDAOImpl implements ApplianceDAO{

	private static final String RESOURCES_APPLIANCES_TXT = "./src/main/resources/appliances_db.txt";

	/**
	 * {@inheritDoc}
	 * Assumes that file is in the correct format
	 */
	@Override
	public Appliance find(Criteria criteria) {
		List<Appliance> matches = new ArrayList<>();
		try {
			List<String> fileLines = new ArrayList<String>();

			File file = new File(RESOURCES_APPLIANCES_TXT);
			fileLines = Files.readAllLines(file.toPath(), Charset.defaultCharset());

			for (String line: fileLines) {
				try {
					if (line.isEmpty())
						continue;

					String[] res = line.split(":");

					if (!res[0].trim().equals(criteria.getGroupSearchName()))
						continue;

					ApplianceCreator ac = ApplianceCreatorFactory.getInstance().getCreator(res[0].trim());
					Appliance appliance = ac.create(res[1].trim());

					Map<String, Object> criterias = criteria.getSearchCriteria();

					boolean isValid = true;

					for (Map.Entry<String, Object> entry : criterias.entrySet()) {
						String key = entry.getKey();
						Object value = entry.getValue();

						if (!appliance.matches(key, value)) {
							isValid = false;
							break;
						}
					}

					if (isValid) {
						matches.add(appliance);
					}
				}
				catch (Exception e) {

				}
			}

		} catch (Exception e) {
			return null;
		}

		if (matches.size() != 0)
			return matches.get(0);
		else
			return null;
	}


}