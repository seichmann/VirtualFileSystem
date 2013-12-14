package com.prodyna.vfs.filesystem.visitor;

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
		// TODO Auto-generated method stub

	}

	public void visit(AudioFileImpl file) {
		// TODO Auto-generated method stub

	}

	public void visit(ImageFileImpl file) {
		// TODO Auto-generated method stub

	}

	public void visit(WordFileImpl file) {
		// TODO Auto-generated method stub

	}

	public void visit(PDFFileImpl file) {
		// TODO Auto-generated method stub

	}

	public void visit(InternalFolderImpl virtualFolderImpl) {
		visitChildren(virtualFolderImpl);
	}

	private void visitChildren(FolderImpl folderImpl) {
		for (NodeImpl node : folderImpl.getChildrenList()) {
			node.accept(this);
		}
	}

	public void visit(FileImpl fileImpl) {
		// TODO Auto-generated method stub

	}

	public void visit(VirtualFolderImpl virtualFolderImpl) {
		visitChildren(virtualFolderImpl);
	}
}
