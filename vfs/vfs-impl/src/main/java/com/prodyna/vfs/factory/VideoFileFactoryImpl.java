package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.VideoFileImpl;

public class VideoFileFactoryImpl extends AbstractFileFactory {

	@Override
	public FileImpl createFile(String name, byte[] content) {
		VideoFileImpl result = new VideoFileImpl();
		result.setName(name);
		result.setContent(content);
		return result;
	}
}
