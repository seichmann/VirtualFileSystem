package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.VideoFileImpl;
import com.prodyna.vfs.model.spec.VideoFileSpecification;

public class VideoFileFactoryImpl extends AbstractFileFactory {

	@Override
	public File createFile(InternalFolderImpl parent, String name, byte[] content) {
		VideoFileImpl result = new VideoFileImpl();
		result.setName(name);
		result.setContent(content);
		addFileToFolder(parent, result);
		return result;
	}
}
