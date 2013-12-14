package com.prodyna.vfs.filesystem.visitor;

import com.prodyna.vfs.BaseSystemVisitor;
import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.ImageFileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.PDFFileImpl;
import com.prodyna.vfs.model.VideoFileImpl;
import com.prodyna.vfs.model.VirtualFolderImpl;
import com.prodyna.vfs.model.WordFileImpl;

public class ListingFileSystemVisitor extends BaseSystemVisitor {

	private int indent = 0;
	@Override
	public void visit(VideoFileImpl file) {
		log(file.getName(), file.getClass().getSimpleName());
	}

	@Override
	public void visit(AudioFileImpl file) {
		log(file.getName(), file.getClass().getSimpleName());
	}

	@Override
	public void visit(ImageFileImpl file) {
		log(file.getName(), file.getClass().getSimpleName());
	}

	@Override
	public void visit(WordFileImpl file) {
		log(file.getName(), file.getClass().getSimpleName());
	}

	@Override
	public void visit(PDFFileImpl file) {
		log(file.getName(), file.getClass().getSimpleName());
	}

	@Override
	public void visit(InternalFolderImpl folder) {
		log(folder.getName(), folder.getClass().getSimpleName());
		
		indent++;
		super.visit(folder);
		indent--;
	}

	private void log(String name, String className) {
		for(int i=0; i < indent; i++) {
			System.out.print(" ");
		}
		System.out.println(name + " : " + className);
	}

	@Override
	public void visit(FileImpl file) {
		log(file.getName(), file.getClass().getSimpleName());
	}

	@Override
	public void visit(VirtualFolderImpl folder) {
		log(folder.getName(), folder.getClass().getSimpleName());
		
		indent++;
		super.visit(folder);
		indent--;
	}
	
}
