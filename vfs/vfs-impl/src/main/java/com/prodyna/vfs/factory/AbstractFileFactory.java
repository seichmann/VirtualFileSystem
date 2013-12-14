package com.prodyna.vfs.factory;

import java.util.HashMap;
import java.util.Map;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.spec.FileSpecification;

public abstract class AbstractFileFactory {
	
	private static final Map<Class<? extends FileSpecification>, AbstractFileFactory> TYPE_REGISTRY = new HashMap<Class<? extends FileSpecification>, AbstractFileFactory>();

	public static AbstractFileFactory getInstance(FileSpecification spec) {
		AbstractFileFactory abstractFileFactory = TYPE_REGISTRY.get(spec.getClass());
		if (abstractFileFactory != null) {
			return abstractFileFactory;
		}
		throw new RuntimeException("specification not found");
	}

	public abstract File createFile(InternalFolderImpl parent, String name,  byte[] content);
	
	protected void addFileToFolder(InternalFolderImpl parent, FileImpl file) {
		parent.getChildrenList().add(file);
	}
	
	static void registerFileType(Class<? extends FileSpecification> specClass, AbstractFileFactory factoryImpl) {
		
	}
}
