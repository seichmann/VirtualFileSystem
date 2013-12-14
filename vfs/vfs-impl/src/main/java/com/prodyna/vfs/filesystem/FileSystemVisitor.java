package com.prodyna.vfs.filesystem;

import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.ImageFileImpl;
import com.prodyna.vfs.model.PDFFileImpl;
import com.prodyna.vfs.model.VideoFileImpl;
import com.prodyna.vfs.model.WordFileImpl;

public interface FileSystemVisitor {

	void visit(VideoFileImpl file);
	void visit(AudioFileImpl file);
	void visit(ImageFileImpl file);
	void visit(WordFileImpl file);
	void visit(PDFFileImpl file);
}
