package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.creator.ApplianceCreator;
import by.tc.task01.dao.creator.ApplianceCreatorFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
	private static final String RESOURCES_APPLIANCES_XML = "./src/main/resources/appliances.xml";

	/**
	 * {@inheritDoc}
	 * Assumes that file is in the correct format
	 */
	@Override
	public Appliance find(Criteria criteria) {
		List<Appliance> matches = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(RESOURCES_APPLIANCES_XML));
			doc.getDocumentElement().normalize();
			NodeList nodes = doc.getDocumentElement().getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					if (!node.getNodeName().equalsIgnoreCase(criteria.getGroupSearchName()))
						continue;

					ApplianceCreator ac = ApplianceCreatorFactory.getInstance().getCreator(node.getNodeName());
					Appliance appliance = ac.create(node.getChildNodes());

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