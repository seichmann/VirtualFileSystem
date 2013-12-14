package com.prodyna.vfs.filesystem.visitor;

import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.ImageFileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.PDFFileImpl;
import com.prodyna.vfs.model.VideoFileImpl;
import com.prodyna.vfs.model.VirtualFolderImpl;
import com.prodyna.vfs.model.WordFileImpl;

public interface FileSystemVisitor {

	void visit(VideoFileImpl file);
	void visit(AudioFileImpl file);
	void visit(ImageFileImpl file);
	void visit(WordFileImpl file);
	void visit(PDFFileImpl file);
	void visit(InternalFolderImpl virtualFolderImpl);
	void visit(FileImpl fileImpl);
	void visit(VirtualFolderImpl virtualFolderImpl);
}
