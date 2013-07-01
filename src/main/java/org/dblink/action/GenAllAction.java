package org.dblink.action;

import java.util.List;

import org.dblink.service.ServiceGenAll;


import com.opensymphony.xwork2.ActionSupport;

/**
 *
 *@author huangyijie
 *
 */
public class GenAllAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String rootpath;
	private List<String> allFiles;
	
	public List<String> getAllFiles() {
		return allFiles;
	}
	
	public void setAllFiles(List<String> allFiles) {
		this.allFiles = allFiles;
	}
	
	public String getRootpath() {
		return rootpath;
	}
	
	public void setRootpath(String rootpath) {
		this.rootpath = rootpath;
	}
	
	public String genAll() throws Exception {
		
		setAllFiles(ServiceGenAll.getAllFiles(rootpath));
		
		return SUCCESS;
	}
	
}
