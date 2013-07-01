package org.dblink.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.dblink.bean.ZTreeJSONBean;
import org.dblink.cfg.SysCfg;


/**
 * 
 * @author huangyijie
 * 
 */
public class FileUtil {

	private static final String root = SysCfg.getRoot();
	
	public static List<String> getAll(File dir, int level, boolean getNew) throws NumberFormatException, ConfigurationException {
		List<String> filePathList = new ArrayList<String>();
		level++;
		File[] files = dir.listFiles();
		long lastUpdateTime = SysCfg.getLastUpdateTime();
		for (int x = 0; x < files.length; x++) {
			File file = files[x];
			if (file.isDirectory()) {
				filePathList.addAll(getAll(file, level, getNew));
			} else {
				if(matchFile(file, getNew, lastUpdateTime)) {
					filePathList.add(getRelativePath(root, file.getAbsolutePath()));
				}
			}
		}
		return filePathList;
	}

	public static List<ZTreeJSONBean> getAllBean(File dir, int pId,
			boolean getNew) throws NumberFormatException,
			ConfigurationException, IOException {
		List<ZTreeJSONBean> filePathList = new ArrayList<ZTreeJSONBean>();
		File[] files = dir.listFiles();
		long lastUpdateTime = SysCfg.getLastUpdateTime();
		for (int x = 0; x < files.length; x++) {
			File file = files[x];
			if (file.isDirectory()) {
				filePathList.add(getPathBean(file, pId, pId * 100 + x + 1,
						true, true));
				filePathList
						.addAll(getAllBean(file, pId * 100 + x + 1, getNew));
			} else {
				String relPath = getRelativePath(root, file.getAbsolutePath());
				if (CacheUtil.containIt(relPath)
						&& matchFile(file, getNew, lastUpdateTime)) {
					filePathList.add(getPathBean(file, pId, pId * 100 + x + 1,
							false, true));
				}
			}
		}
		return filePathList;
	}
	
	public static List<String> getAll(File dir, int level) throws NumberFormatException, ConfigurationException {
		return getAll(dir, level, false);
	}

	private static boolean matchFile(File file, boolean getNew, long lastUpdateTime) throws ConfigurationException {
		
		boolean result = false;
		
		List<String> filterNames = SysCfg.getFilterNames();
		
		for(String filteName : filterNames) {
			if(getNew && file.lastModified() < lastUpdateTime)
				return false;
			if(file.getName().endsWith(filteName))
				return true;
		}
		
		return result;
	}
	
	public static String getRelativePath(String relPathName, String fileName) {
		if(fileName.startsWith(relPathName))
			return fileName.replace(relPathName, "");
		else 
			return fileName;
	}
	
	public static ZTreeJSONBean getPathBean(File file, int pId, int id, boolean isFolder, boolean open) {
		ZTreeJSONBean bean = new ZTreeJSONBean();
		bean.setId(id);
		bean.setName(file.getName());
		bean.setOpen(open);
		bean.setpId(pId);
		bean.setFolder(isFolder);
		bean.setFullPath(getRelativePath(root, file.getAbsolutePath()));
		return bean;
	}
}
