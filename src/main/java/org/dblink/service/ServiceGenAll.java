package org.dblink.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.dblink.bean.ZTreeJSONBean;
import org.dblink.cfg.SysCfg;
import org.dblink.utils.EncodeUtil;
import org.dblink.utils.FileUtil;
import org.dblink.utils.IniUtil;



/**
 * 
 * @author huangyijie
 * 
 */
public class ServiceGenAll {

	public static List<String> getAllFiles(String rootPath) throws IOException, ConfigurationException {
		return getAllFiles(rootPath, false);
	}
	
	public static List<String> getAllFiles(String rootPath, boolean getNew) throws IOException, ConfigurationException {
		String configPath = SysCfg.configPath;
		String dbRootPath = IniUtil.getItem(configPath, "sysinfo", "rootpath");
		List<String> filePathList = FileUtil.getAll(new File(dbRootPath
				+ rootPath), 0, getNew);
		return filePathList;
	}
	
	public static List<ZTreeJSONBean> getAllFileBeans(String rootPath, boolean getNew) throws IOException, ConfigurationException {
		String configPath = SysCfg.configPath;
		String dbRootPath = IniUtil.getItem(configPath, "sysinfo", "rootpath");
		return FileUtil.getAllBean(new File(dbRootPath), 0, getNew);
	}

	public static List<String> genAllUrl(List<String> relPathList)
			throws IOException, ConfigurationException {

		List<String> allUrl = new ArrayList<String>();
		String configPath = SysCfg.configPath;
		String usercode = IniUtil.getItem(configPath, "userinfo", "usercode");
		String domain = IniUtil.getItem(configPath, "userinfo", "domain");

		for (int i = 0; i < relPathList.size(); i++) {
			String url = "http://" + domain + "/u/" + usercode + "/"
					+ EncodeUtil.encodeSpace(relPathList.get(i));
			allUrl.add(url);
		}

		return allUrl;
	}
	
	public static List<ZTreeJSONBean> getNewJSON(String rootPath, boolean getNew) throws ConfigurationException, IOException {
		return getAllFileBeans(rootPath, getNew);
	}
}
