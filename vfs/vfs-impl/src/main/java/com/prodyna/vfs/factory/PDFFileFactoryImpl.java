package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.PDFFileImpl;
import com.prodyna.vfs.model.spec.PDFFileSpecification;

public class PDFFileFactoryImpl extends AbstractFileFactory {

	private static final PDFFileFactoryImpl instance;

	@Override
	public File createFile(InternalFolderImpl parent, String name, byte[] content) {
		PDFFileImpl result = new PDFFileImpl();
		result.setName(name);
		result.setContent(content);
		addFileToFolder(parent, result);
		return result;
	}
	
	static {
		instance = new PDFFileFactoryImpl();
		AbstractFileFactory.registerFileType(PDFFileSpecification.class, instance);
	}
	
}
