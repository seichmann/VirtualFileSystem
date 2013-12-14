package com.prodyna.vfs.filesystem;

import com.prodyna.vfs.Observable;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.NodeImpl;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.FolderSpecification;

public interface FileSystem extends Observable {

	FolderImpl createFolder(String name, FolderSpecification specification);
	
	FileImpl createFile(FolderImpl parent, String name, byte[] content, FileSpecification spec);

	void addChild(FolderImpl parent, NodeImpl child);
}
