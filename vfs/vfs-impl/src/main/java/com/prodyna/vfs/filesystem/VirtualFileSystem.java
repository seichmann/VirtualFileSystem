package com.prodyna.vfs.filesystem;

import com.prodyna.vfs.FileSystemListener;
import com.prodyna.vfs.factory.VirtualFolderFactoryImpl;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.NodeImpl;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.FolderSpecification;

public class VirtualFileSystem implements FileSystem {
	
	private VirtualFolderFactoryImpl folderFactory = new VirtualFolderFactoryImpl();

	public void register(Node node, FileSystemListener listener) {
		throw new UnsupportedOperationException();
	}

	public void unRegister(Node node, FileSystemListener listener) {
		throw new UnsupportedOperationException();
	}

	public FolderImpl createFolder(String name,
			FolderSpecification specification) {
		throw new UnsupportedOperationException();
	}

	public FileImpl createFile(FolderImpl parent, String name, byte[] content,
			FileSpecification spec) {
		throw new UnsupportedOperationException();
	}

	public void addChild(FolderImpl parent, NodeImpl child) {
		throw new UnsupportedOperationException();
	}

}
