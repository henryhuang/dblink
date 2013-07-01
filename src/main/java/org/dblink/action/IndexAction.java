package org.dblink.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 *@author huangyijie
 *
 */
public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String execute() throws Exception {
		return SUCCESS;
	}
	
}
