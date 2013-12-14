package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.WordFileImpl;

public class WordFileFactoryImpl extends AbstractFileFactory {
	
	@Override
	public FileImpl createFile(String name, byte[] content) {
		WordFileImpl result = new WordFileImpl();
		result.setName(name);
		result.setContent(content);
		return result;
	}
}
