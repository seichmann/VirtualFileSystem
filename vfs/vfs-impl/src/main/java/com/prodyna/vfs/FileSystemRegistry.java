package com.prodyna.vfs;

import java.util.HashMap;
import java.util.Map;

import com.prodyna.vfs.filesystem.FileSystem;
import com.prodyna.vfs.filesystem.InternalFileSystem;
import com.prodyna.vfs.filesystem.VirtualFileSystem;
import com.prodyna.vfs.model.filesystem.FileSystemType;

public final class FileSystemRegistry {
	
	private final Map<FileSystemType, FileSystem> registry = new HashMap<FileSystemType, FileSystem>();
	
	private static final FileSystemRegistry instance = new FileSystemRegistry();
	
	private FileSystemRegistry() {
		registry.put(FileSystemType.INTERNAL, new InternalFileSystem());
		registry.put(FileSystemType.VIRTUAL, new VirtualFileSystem());
	}
	
	public FileSystem getFileSystem(FileSystemType fileSystemType) {
		return registry.get(fileSystemType);
	}
	
	public static FileSystemRegistry getInstance() {
		return instance;
	}

}
