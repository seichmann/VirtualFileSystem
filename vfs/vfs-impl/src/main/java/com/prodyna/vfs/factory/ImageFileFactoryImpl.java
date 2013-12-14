package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.ImageFileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.spec.ImageFileSpecification;

public class ImageFileFactoryImpl extends AbstractFileFactory {

	@Override
	public File createFile(InternalFolderImpl parent, String name, byte[] content) {
		ImageFileImpl result = new ImageFileImpl();
		result.setName(name);
		result.setContent(content);
		addFileToFolder(parent, result);
		return result;
	}

}
