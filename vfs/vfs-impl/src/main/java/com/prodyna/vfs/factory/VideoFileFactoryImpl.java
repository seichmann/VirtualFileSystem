package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.NodeType;
import com.prodyna.vfs.model.VideoFileImpl;

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
