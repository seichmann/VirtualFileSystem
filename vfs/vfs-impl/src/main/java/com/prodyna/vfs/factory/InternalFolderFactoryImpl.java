package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.InternalFolderImpl;

public class InternalFolderFactoryImpl  {

	public FolderImpl createFolder(String name) {
		InternalFolderImpl result = new InternalFolderImpl();
		result.setName(name);
		return result;
	}

}
