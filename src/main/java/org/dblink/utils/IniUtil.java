package org.dblink.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.apache.commons.configuration.SubnodeConfiguration;


/**
 * 
 * @author huangyijie
 * 
 */
public class IniUtil {

	public static String getItem(String filePath, String sectionName,
			String itemName) throws IOException, ConfigurationException {

		HierarchicalINIConfiguration iniConfig = new HierarchicalINIConfiguration(new File(filePath));
		SubnodeConfiguration section = iniConfig.getSection(sectionName);

		return section.getString(itemName);
	}

	public static void setItem(String filePath, String sectionName,
			String itemName, String itemValue) throws IOException, ConfigurationException {
		HierarchicalINIConfiguration iniConfig = new HierarchicalINIConfiguration(new File(filePath));
		SubnodeConfiguration sub = iniConfig.getSection(sectionName);
		sub.setProperty(itemName, itemValue);
		iniConfig.save(new File(filePath));
	}

}
