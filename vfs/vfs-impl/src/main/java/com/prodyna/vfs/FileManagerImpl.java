package com.prodyna.vfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.prodyna.vfs.filesystem.FileSystem;
import com.prodyna.vfs.filesystem.FileSystemEventImpl;
import com.prodyna.vfs.filesystem.InternalFileSystem;
import com.prodyna.vfs.filesystem.VirtualFileSystem;
import com.prodyna.vfs.filesystem.visitor.ListingFileSystemVisitor;
import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.FolderImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.NodeImpl;
import com.prodyna.vfs.model.filesystem.FileSystemType;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.FolderSpecification;

public class FileManagerImpl implements FileManager, FileSystemListener {

	private final VirtualFileSystem virtualFileFystem = new VirtualFileSystem();
	private final InternalFileSystem internalFileFystem = new InternalFileSystem();
	
	private static final FileManagerImpl INSTANCE = new FileManagerImpl();
	private InternalFolderImpl rootNode;
	private FileSystemEventHelper fileSystemEventHelper = new FileSystemEventHelper();
	
	public FileManagerImpl() {
		rootNode = new InternalFolderImpl();
		rootNode.setName("root");
	}
	
	public Folder getRoot() {
		return rootNode;
	}

	public Folder addFolder(Folder parent, String name, FolderSpecification spec) {
		FileSystem fileSystem = getFileSystem(spec);
		Folder folder = fileSystem.createFolder(name, spec);
		fileSystem.register(folder, this);
		getFileSystem(parent.getSystemType()).addChild((FolderImpl) parent, (NodeImpl) folder);
		return folder;
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
		FileSystem fileSystem = getFileSystem(parent.getSystemType());
		File file = fileSystem.createFile((FolderImpl) parent, name, content, spec);
		fileSystem.register(file, this);
		return file;
	}

	private FileSystem getFileSystem(FileSystemType systemType) {
		switch (systemType) {
		case VIRTUAL: 
			return virtualFileFystem;
		case INTERNAL:
		default:
			return internalFileFystem;
		}
	}

	public FileManager getInstance() {
			return INSTANCE;
		}

	public void list() {
		rootNode.accept(new ListingFileSystemVisitor());
	}

	/**
	 * @param node
	 * @param listener
	 * @see com.prodyna.vfs.FileSystemEventHelper#register(com.prodyna.vfs.model.Node, com.prodyna.vfs.FileSystemListener)
	 */
	public void register(Node node, FileSystemListener listener) {
		fileSystemEventHelper.register(node, listener);
	}

	/**
	 * @param node
	 * @param listener
	 * @see com.prodyna.vfs.FileSystemEventHelper#unRegister(com.prodyna.vfs.model.Node, com.prodyna.vfs.FileSystemListener)
	 */
	public void unRegister(Node node, FileSystemListener listener) {
		fileSystemEventHelper.unRegister(node, listener);
	}

	public void eventCallback(FileSystemEvent event) {
		fileSystemEventHelper.fireEvent(event);
		NodeImpl node = (NodeImpl) event.getNode();
		while ((node = node.getParent()) != null) {
			
			fileSystemEventHelper.fireEvent(new FileSystemEventImpl(node, event.getEventType()));
		}
	}
}
