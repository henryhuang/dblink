package org.dblink.action;

import java.util.Date;
import java.util.List;

import org.dblink.bean.ZTreeJSONBean;
import org.dblink.cfg.SysCfg;
import org.dblink.service.ServiceGenAll;
import org.dblink.utils.IniUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author huangyijie
 *
 */
public class GenNewAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<String> allFiles;
	private List<String> allUrls;
	private String jsonData;
	private List<ZTreeJSONBean> jsonBeanList;
	
	public List<String> getAllFiles() {
		return allFiles;
	}
	
	public void setAllFiles(List<String> allFiles) {
		this.allFiles = allFiles;
	}
	
	public List<String> getAllUrls() {
		return allUrls;
	}
	
	public void setAllUrls(List<String> allUrls) {
		this.allUrls = allUrls;
	}
	
	public String getJsonData() {
		return jsonData;
	}
	
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	
	public List<ZTreeJSONBean> getJsonBeanList() {
		return jsonBeanList;
	}
	
	public void setJsonBeanList(List<ZTreeJSONBean> jsonBeanList) {
		this.jsonBeanList = jsonBeanList;
	}
	
	public String getNew() throws Exception {
		setAllFiles(ServiceGenAll.getAllFiles("", true));
		return SUCCESS;
	}
	
	public String genNew() throws Exception {
		try {
			List<String> allFiles = ServiceGenAll.getAllFiles("", true);
			setAllUrls(ServiceGenAll.genAllUrl(allFiles));
			IniUtil.setItem(SysCfg.configPath, "sysinfo", "lastupdatetime", (new Date().getTime())+"");
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String getNewJSON() throws Exception {
		try {
			setJsonBeanList(ServiceGenAll.getNewJSON("", true));
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
}
