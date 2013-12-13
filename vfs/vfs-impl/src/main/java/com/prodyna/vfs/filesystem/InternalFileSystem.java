package com.prodyna.vfs.filesystem;

import com.prodyna.vfs.factory.AbstractFileFactory;
import com.prodyna.vfs.factory.InternalFolderFactoryImpl;
import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.spec.FileSpecification;

public class InternalFileSystem implements FileSystem {

	private InternalFolderFactoryImpl folderFactory = new InternalFolderFactoryImpl();
	
	public Folder createFolder(Folder parent, String name) {
		return folderFactory.createFolder(parent, name);
	}

	public File createFile(Folder parent, String name, byte[] content,
			FileSpecification spec) {
		return AbstractFileFactory.getInstance(spec).createFile((InternalFolderImpl) parent, name, content);
	}
}
