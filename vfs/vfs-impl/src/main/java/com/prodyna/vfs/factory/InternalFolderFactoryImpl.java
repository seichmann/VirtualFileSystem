package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.NodeType;

public class InternalFolderFactoryImpl  {

	public Folder createFolder(Folder parent, String name) {
		InternalFolderImpl result = new InternalFolderImpl();
		result.setName(name);
		return result;
	}

}
