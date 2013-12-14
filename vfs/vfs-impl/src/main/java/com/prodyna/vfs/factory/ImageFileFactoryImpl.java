package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.ImageFileImpl;

public class ImageFileFactoryImpl extends AbstractFileFactory {

	@Override
	public FileImpl createFile(String name, byte[] content) {
		ImageFileImpl result = new ImageFileImpl();
		result.setName(name);
		result.setContent(content);
		return result;
	}

}
