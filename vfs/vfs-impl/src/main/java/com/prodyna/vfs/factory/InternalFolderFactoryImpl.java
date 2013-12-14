package com.prodyna.vfs.factory;

import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.NodeType;

public class InternalFolderFactoryImpl  {

	public Folder createFolder(InternalFolderImpl parent, String name) {
		InternalFolderImpl result = new InternalFolderImpl();
		result.setName(name);
		parent.getChildrenList().add(result);
		return result;
	}

}
