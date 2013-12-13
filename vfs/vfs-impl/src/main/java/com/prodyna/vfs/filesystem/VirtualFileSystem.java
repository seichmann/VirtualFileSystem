package com.prodyna.vfs.filesystem;

import com.prodyna.vfs.factory.VirtualFolderFactoryImpl;
import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.spec.FileSpecification;

public class VirtualFileSystem implements FileSystem {
	
	private VirtualFolderFactoryImpl folderFactory = new VirtualFolderFactoryImpl();
	public Folder createFolder(Folder parent, String name) {
		return folderFactory.createFolder(parent, name);
	}
	public File createFile(Folder parent, String name, byte[] content,
			FileSpecification spec) {
		throw new UnsupportedOperationException("Denied!.");
	}
}
