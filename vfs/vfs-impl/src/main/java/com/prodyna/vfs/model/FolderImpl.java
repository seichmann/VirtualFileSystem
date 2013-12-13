package com.prodyna.vfs.model;

import java.util.ArrayList;
import java.util.List;


public abstract class FolderImpl extends NodeImpl implements Folder {
	private List<NodeImpl> childrenList = new ArrayList<NodeImpl>();
	
	public List<NodeImpl> getChildrenList() {
		return childrenList;
	}
	@Override
	public NodeType getType() {
		return NodeType.FOLDER;
	}
}
