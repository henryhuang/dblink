package org.dblink.bean;

public class ZTreeJSONBean {
	
	private int id;
	private int pId;
	private String name;
	private boolean open;
	private String fullPath;
	private boolean folder;
	
	public String getFullPath() {
		return fullPath;
	}
	
	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isFolder() {
		return folder;
	}

	public void setFolder(boolean folder) {
		this.folder = folder;
	}

}
