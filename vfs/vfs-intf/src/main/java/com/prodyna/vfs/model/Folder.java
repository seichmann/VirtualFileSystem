package com.prodyna.vfs.model;

import com.prodyna.vfs.model.filesystem.FileSystemType;

public interface Folder extends Node{
	FileSystemType getSystemType();
}
