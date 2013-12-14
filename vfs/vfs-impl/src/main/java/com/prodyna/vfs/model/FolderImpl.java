package com.prodyna.vfs.model;

import java.util.ArrayList;
import java.util.List;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;


public abstract class FolderImpl extends NodeImpl implements Folder {
	private List<NodeImpl> childrenList = new ArrayList<NodeImpl>();
	
	public List<NodeImpl> getChildrenList() {
		return childrenList;
	}
	@Override
	public NodeType getType() {
		return NodeType.FOLDER;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FolderImpl [getType()=" + getSystemType() + ", getName()="
				+ getName() + "]";
	}
}
