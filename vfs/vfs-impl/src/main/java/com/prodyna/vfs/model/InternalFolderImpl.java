package com.prodyna.vfs.model;

import java.util.ArrayList;
import java.util.List;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;
import com.prodyna.vfs.model.filesystem.FileSystemType;

public class InternalFolderImpl extends FolderImpl implements Folder {

	private List<NodeImpl> childrenList = new ArrayList<NodeImpl>();
	
	public List<NodeImpl> getChildrenList() {
		return childrenList;
	}
	
	public FileSystemType getSystemType() {
		return FileSystemType.INTERNAL;
	}
	
	public void accept(FileSystemVisitor visitor) {
		visitor.visit(this);
	}
}
