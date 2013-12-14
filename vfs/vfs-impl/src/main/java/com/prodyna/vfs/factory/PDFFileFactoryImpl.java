package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.PDFFileImpl;

public class PDFFileFactoryImpl extends AbstractFileFactory {

	@Override
	public FileImpl createFile(String name, byte[] content) {
		PDFFileImpl result = new PDFFileImpl();
		result.setName(name);
		result.setContent(content);
		return result;
	}
	
}
