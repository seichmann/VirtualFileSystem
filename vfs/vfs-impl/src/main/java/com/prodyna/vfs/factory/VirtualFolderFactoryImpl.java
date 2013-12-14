package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.VirtualFolderImpl;

public class VirtualFolderFactoryImpl {

	public FolderImpl createFolder(String name) {
		VirtualFolderImpl folder = new VirtualFolderImpl();
		folder.setName(name);
		return folder;
	}
}
