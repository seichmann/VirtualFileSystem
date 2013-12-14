package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.FileImpl;

public class AudioFileFactoryImpl extends AbstractFileFactory {

	@Override
	public FileImpl createFile(String name, byte[] content) {
		AudioFileImpl result = new AudioFileImpl();
		result.setName(name);
		result.setContent(content);
		return result;
	}
}
