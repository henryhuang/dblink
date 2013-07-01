package org.dblink.action;

import org.dblink.service.ServiceGenOne;
import org.dblink.utils.CacheUtil;
import org.dblink.utils.JedisUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 *@author huangyijie
 *
 */
public class ServiceAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String relpath;
	private String oneUrl;
	private String toMarkFile;
	
	public String getRelpath() {
		return relpath;
	}
	
	public void setRelpath(String relpath) {
		this.relpath = relpath;
	}
	
	public void setOneUrl(String oneUrl) {
		this.oneUrl = oneUrl;
	}
	
	public String getOneUrl() {
		return oneUrl;
	}
	
	public String getToMarkFile() {
		return toMarkFile;
	}

	public void setToMarkFile(String toMarkFile) {
		this.toMarkFile = toMarkFile;
	}

	public String genOne() throws Exception {
		
		setOneUrl(ServiceGenOne.genOneUrl(relpath));
		
		return SUCCESS;
	}
	
	public String genOneJSON() throws Exception {
		setOneUrl(ServiceGenOne.genOneUrl(relpath));
		return SUCCESS;
	}
	
	public String markFile() throws Exception {
		// 存放到数据库里面
		JedisUtil util = new JedisUtil();
		util.markDisShowStatus(toMarkFile);
		CacheUtil.removeIt(toMarkFile);
		return SUCCESS;
	}
}
