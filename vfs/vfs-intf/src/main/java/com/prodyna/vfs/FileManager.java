package com.prodyna.vfs;

import java.util.Set;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.FolderSpecification;
import com.prodyna.vfs.search.SearchCriteria;

public interface FileManager extends Observable {

	Folder getRoot();
	
	Folder addFolder(Folder parent, String name, FolderSpecification spec);
	
	Folder addFolder(Folder parent, String name);
	
	Set<Node> getChildren(Folder parent);
	
	File addFile(Folder parent, String name, byte[] content, FileSpecification spec);

	FileManager getInstance();
	
	long getFolderSize(Folder folder);

	void list();
	
	Set<Node> search(SearchCriteria searchCriteria);

	Set<Node> search(SearchCriteria searchCriteria, Folder folder);
}
