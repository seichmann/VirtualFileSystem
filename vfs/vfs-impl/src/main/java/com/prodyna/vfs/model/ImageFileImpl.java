package com.prodyna.vfs.model;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;

public class ImageFileImpl extends MediaFileImpl {
	public void accept(FileSystemVisitor visitor) {
		visitor.visit(this);
	}
}
