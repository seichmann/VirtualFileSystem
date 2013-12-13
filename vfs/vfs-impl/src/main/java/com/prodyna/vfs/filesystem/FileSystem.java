package com.prodyna.vfs.filesystem;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.spec.FileSpecification;

public interface FileSystem {

	Folder createFolder(Folder parent, String name);

	File createFile(Folder parent, String name, byte[] content, FileSpecification spec);

}
