package com.prodyna.vfs.model;


public abstract class NodeImpl implements Node, Visitable {

	private String name;
	private NodeImpl parent;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract NodeType getType();

	public void setParent(FolderImpl parent) {
		this.parent = parent;
	}

	public NodeImpl getParent() {
		return parent;
	}
	
}
