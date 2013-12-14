package com.prodyna.vfs.model;

import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;

public class FileImpl extends NodeImpl implements File{
	private byte[] content;
	
	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public int getSize() {
		return content.length;
	}

	@Override
	public NodeType getType() {
		return NodeType.FILE;
	}

	public void accept(FileSystemVisitor visitor) {
		visitor.visit(this);
	}
}
