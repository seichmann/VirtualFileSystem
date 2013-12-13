package com.prodyna.vfs.model;

import com.prodyna.vfs.model.filesystem.FileSystemType;

public class InternalFolderImpl extends FolderImpl implements Folder {
	public FileSystemType getSystemType() {
		return FileSystemType.INTERNAL;
	}
}
