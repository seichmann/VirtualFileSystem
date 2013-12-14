package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.spec.AudioFileSpecification;

public class AudioFileFactoryImpl extends AbstractFileFactory {

	@Override
	public File createFile(InternalFolderImpl parent, String name, byte[] content) {
		AudioFileImpl result = new AudioFileImpl();
		result.setName(name);
		result.setContent(content);
		addFileToFolder(parent, result);
		return result;
	}
}
