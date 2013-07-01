package org.dblink.cfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.dblink.utils.IniUtil;



/**
 *
 *@author huangyijie
 *
 */
public class SysCfg {

	public static final String configPath = SysCfg.class.getResource("/").getPath() + "../conf/config.ini";

	public static List<String> filterNames;
	
	public static long lastUpdateTime;
	
	public static final String getRoot() {
		try {
			return IniUtil.getItem(configPath, "sysinfo", "rootpath");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} 
	}
	
	public static final long getLastUpdateTime() throws NumberFormatException, ConfigurationException {
		try {
			return Long.parseLong(IniUtil.getItem(configPath, "sysinfo", "lastupdatetime").toString());
		} catch (IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static final List<String> getFilterNames() throws ConfigurationException {
		if(filterNames == null)
			initFilterNames();
		return filterNames;
	}
	
	private static void initFilterNames() throws ConfigurationException {
		List<String> result = new ArrayList<String>();
		try {
			String filterNameStr = IniUtil.getItem(configPath, "sysinfo", "filefilter");
			String[] filterNames = filterNameStr.split(",");
			result = Arrays.asList(filterNames);
		} catch (IOException e) {
			e.printStackTrace();
		}
		filterNames = result;
	}
}
