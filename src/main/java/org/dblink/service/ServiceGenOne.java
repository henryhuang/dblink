package org.dblink.service;

import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.dblink.cfg.SysCfg;
import org.dblink.utils.EncodeUtil;
import org.dblink.utils.IniUtil;



/**
 *
 *@author huangyijie
 *
 */
public class ServiceGenOne {
	
	
	public static String genOneUrl(String relPath) throws IOException, ConfigurationException {
		
		String configPath = SysCfg.configPath;
		String usercode = IniUtil.getItem(configPath, "userinfo", "usercode");
		String domain = IniUtil.getItem(configPath, "userinfo", "domain");
		
		String url = "http://" + domain + "/u/" + usercode + "/" + EncodeUtil.encodeSpace(relPath);
		
		return url;
	}
	
}
