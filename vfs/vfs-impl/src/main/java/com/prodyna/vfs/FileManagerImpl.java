package com.prodyna.vfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.prodyna.vfs.filesystem.FileSystem;
import com.prodyna.vfs.filesystem.InternalFileSystem;
import com.prodyna.vfs.filesystem.VirtualFileSystem;
import com.prodyna.vfs.filesystem.visitor.ListingFileSystemVisitor;
import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.filesystem.FileSystemType;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.FolderSpecification;

public class FileManagerImpl implements FileManager{

	private static final FileManagerImpl INSTANCE = new FileManagerImpl();
	private InternalFolderImpl rootNode;
	
	public FileManagerImpl() {
		rootNode = new InternalFolderImpl();
		rootNode.setName("root");
	}
	
	public Folder getRoot() {
		return rootNode;
	}

	public Folder addFolder(Folder parent, String name, FolderSpecification spec) {
		return getFileSystem(spec).createFolder(parent, name);
	}

	private FileSystem getFileSystem(FolderSpecification spec) {
		return getFileSystem(spec.getSystemType());
	}
	
	public Folder addFolder(Folder parent, String name) {
		return addFolder(parent, name, new FolderSpecification() {
			
			public FileSystemType getSystemType() {
				return FileSystemType.INTERNAL;
			}
		});
	}

	public List<Node> getChildren(Folder parent) {
		List<Node> result = new ArrayList<Node>();
		result.addAll(((FolderImpl) parent).getChildrenList());
		return Collections.unmodifiableList(result);
	}

	public File addFile(Folder parent, String name, byte[] content, FileSpecification spec) {
		return getFileSystem(parent.getSystemType()).createFile(parent, name, content, spec);
	}

	private FileSystem getFileSystem(FileSystemType systemType) {
		switch (systemType) {
		case VIRTUAL:
			return new VirtualFileSystem();
		case INTERNAL:
		default:
			return new InternalFileSystem();
		}
	}

	public FileManager getInstance() {
			return INSTANCE;
		}

	public void list() {
		rootNode.accept(new ListingFileSystemVisitor());
	}
}
