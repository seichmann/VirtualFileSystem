package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.WordFileImpl;

public class WordFileFactoryImpl extends AbstractFileFactory {
	
	@Override
	public File createFile(InternalFolderImpl parent, String name, byte[] content) {
		WordFileImpl result = new WordFileImpl();
		result.setName(name);
		result.setContent(content);
		addFileToFolder(parent, result);
		return result;
	}
}
