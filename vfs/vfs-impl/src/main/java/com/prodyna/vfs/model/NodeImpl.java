package com.prodyna.vfs.model;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;

public abstract class NodeImpl implements Node, Visitable {

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract NodeType getType();
	
}
