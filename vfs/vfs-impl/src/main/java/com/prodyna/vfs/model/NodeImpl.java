package com.prodyna.vfs.model;

public abstract class NodeImpl implements Node {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract NodeType getType();
}
