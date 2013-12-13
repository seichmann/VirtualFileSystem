package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.spec.AudioFileSpecification;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.PDFFileSpecification;
import com.prodyna.vfs.model.spec.VideoFileSpecification;
import com.prodyna.vfs.model.spec.WordFileSpecification;

public abstract class AbstractFileFactory {

	public static AbstractFileFactory getInstance(FileSpecification spec) {
		if (spec instanceof AudioFileSpecification) {
			return new AudioFileFactoryImpl();
		} else if (spec instanceof VideoFileSpecification) {
			return new VideoFileFactoryImpl();
		} else if (spec instanceof PDFFileSpecification) {
			return new PDFFileFactoryImpl();
		} else if (spec instanceof WordFileSpecification) {
			return new WordFileFactoryImpl();
		} else {
			throw new RuntimeException("xxx");
		}
	}

	public abstract File createFile(InternalFolderImpl parent, String name,  byte[] content);
	
	protected void addFileToFolder(InternalFolderImpl parent, FileImpl file) {
		parent.getChildrenList().add(file);
	}
}
