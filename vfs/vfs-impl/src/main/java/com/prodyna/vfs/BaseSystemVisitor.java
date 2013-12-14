package com.prodyna.vfs;

import com.prodyna.vfs.filesystem.FileSystem;
import com.prodyna.vfs.filesystem.visitor.FileSystemVisitor;
import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.ImageFileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.NodeImpl;
import com.prodyna.vfs.model.PDFFileImpl;
import com.prodyna.vfs.model.VideoFileImpl;
import com.prodyna.vfs.model.VirtualFolderImpl;
import com.prodyna.vfs.model.WordFileImpl;

public class BaseSystemVisitor implements FileSystemVisitor {

	public void visit(VideoFileImpl file) {
	}

	public void visit(AudioFileImpl file) {
	}

	public void visit(ImageFileImpl file) {
	}

	public void visit(WordFileImpl file) {
	}

	public void visit(PDFFileImpl file) {
	}

	public void visit(InternalFolderImpl virtualFolderImpl) {
		visitChildren(virtualFolderImpl);
	}

	private void visitChildren(FolderImpl folder) {
		FileSystem fileSystem = FileSystemRegistry.getInstance().getFileSystem(folder.getSystemType());
		for (NodeImpl node : fileSystem.getChildren(folder)) {
			node.accept(this);
		}
	}

	public void visit(FileImpl fileImpl) {
	}

	public void visit(VirtualFolderImpl virtualFolderImpl) {
		visitChildren(virtualFolderImpl);
	}
}
