package com.prodyna.vfs.model;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;

public class PDFFileImpl extends TextFileImpl {
	public void accept(FileSystemVisitor visitor) {
		visitor.visit(this);
	}
}
