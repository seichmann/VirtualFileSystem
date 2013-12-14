package com.prodyna.vfs.model;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;

public interface Visitable {
	void accept(FileSystemVisitor visitor);
}
