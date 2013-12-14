package com.prodyna.vfs;

import java.util.List;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.FolderSpecification;

public interface FileManager extends Observable {

	Folder getRoot();
	
	Folder addFolder(Folder parent, String name, FolderSpecification spec);
	
	Folder addFolder(Folder parent, String name);
	
	List<Node> getChildren(Folder parent);
	
	File addFile(Folder parent, String name, byte[] content, FileSpecification spec);

	FileManager getInstance();

	void list();
}
