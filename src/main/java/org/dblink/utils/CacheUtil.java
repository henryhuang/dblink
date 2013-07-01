package org.dblink.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.dblink.cfg.SysCfg;

public class CacheUtil {

	private static List<String> nodeList = null;

	public static synchronized List<String> getNodeMap()
			throws NumberFormatException, ConfigurationException, IOException {
		if (nodeList == null) {
			nodeList = new ArrayList<String>();
			nodeList = FileUtil.getAll(
					new File(IniUtil.getItem(SysCfg.configPath, "sysinfo",
							"rootpath")), 0, true);
		}
		return nodeList;
	}

	public static boolean containIt(String key) throws NumberFormatException,
			ConfigurationException, IOException {
		return getNodeMap().contains(key);
	}

	public static void removeIt(String key) throws NumberFormatException,
			ConfigurationException, IOException {
		getNodeMap().remove(key);
	}
}
