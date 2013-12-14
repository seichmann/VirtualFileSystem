package com.prodyna.vfs.filesystem;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import com.prodyna.vfs.FileSystemEvent;
import com.prodyna.vfs.FileSystemEventEnum;
import com.prodyna.vfs.FileSystemEventHelper;
import com.prodyna.vfs.FileSystemListener;
import com.prodyna.vfs.factory.AbstractFileFactory;
import com.prodyna.vfs.factory.InternalFolderFactoryImpl;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.NodeImpl;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.FolderSpecification;

public class InternalFileSystem implements FileSystem {

	private InternalFolderFactoryImpl folderFactory = new InternalFolderFactoryImpl();
	FileSystemEventHelper eventHelper = new FileSystemEventHelper();
	
	public FolderImpl createFolder(String name, FolderSpecification spec) {
		return folderFactory.createFolder(name);
	}

	public FileImpl createFile(FolderImpl parent, String name, byte[] content,
			FileSpecification spec) {
		AbstractFileFactory factory = AbstractFileFactory.getInstance(spec);
		FileImpl file = factory.createFile(name, content);
		addChild(parent, file);
		FileSystemEvent event = new FileSystemEventImpl(parent, FileSystemEventEnum.ADD);
		eventHelper.fireEvent(event);
		return file;
	}
	
	public void addChild(FolderImpl parent, NodeImpl child) {
		((InternalFolderImpl) parent).getChildrenList().add(child);
		child.setParent(parent);
	}

	public void register(Node node, FileSystemListener listener) {
		eventHelper.register(node, listener);
	}

	public void unRegister(Node node, FileSystemListener listener) {
		eventHelper.unRegister(node, listener);
	}

	public Set<NodeImpl> getChildren(FolderImpl folder) {
		LinkedHashSet<NodeImpl> children = new LinkedHashSet<NodeImpl>(((InternalFolderImpl) folder).getChildrenList());
		return Collections.unmodifiableSet(children);
	}

}
