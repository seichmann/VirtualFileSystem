package com.prodyna.vfs.model;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;
import com.prodyna.vfs.model.filesystem.FileSystemType;

public class VirtualFolderImpl extends FolderImpl implements Folder {
	public FileSystemType getSystemType() {
		return FileSystemType.VIRTUAL;
	}

	public void accept(FileSystemVisitor visitor) {
		visitor.visit(this);
	}
}
