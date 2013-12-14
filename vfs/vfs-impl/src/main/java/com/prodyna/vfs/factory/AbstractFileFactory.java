package com.prodyna.vfs.factory;

import java.util.HashMap;
import java.util.Map;

import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.spec.AudioFileSpecification;
import com.prodyna.vfs.model.spec.FileSpecification;
import com.prodyna.vfs.model.spec.ImageFileSpecification;
import com.prodyna.vfs.model.spec.PDFFileSpecification;
import com.prodyna.vfs.model.spec.VideoFileSpecification;
import com.prodyna.vfs.model.spec.WordFileSpecification;

public abstract class AbstractFileFactory {
	
	private static final Map<Class<? extends FileSpecification>, AbstractFileFactory> TYPE_REGISTRY = new HashMap<Class<? extends FileSpecification>, AbstractFileFactory>();

	public static AbstractFileFactory getInstance(FileSpecification spec) {
		AbstractFileFactory abstractFileFactory = TYPE_REGISTRY.get(spec.getClass());
		if (abstractFileFactory != null) {
			return abstractFileFactory;
		}
		throw new RuntimeException("specification not found");
	}

	public abstract FileImpl createFile(String name,  byte[] content);
	
	static void registerFileType(Class<? extends FileSpecification> specClass, AbstractFileFactory factoryImpl) {
		TYPE_REGISTRY.put(specClass, factoryImpl);
	}
	
	static {
		AbstractFileFactory.registerFileType(AudioFileSpecification.class,  new AudioFileFactoryImpl());
		AbstractFileFactory.registerFileType(VideoFileSpecification.class,  new VideoFileFactoryImpl());
		AbstractFileFactory.registerFileType(PDFFileSpecification.class,  new PDFFileFactoryImpl());
		AbstractFileFactory.registerFileType(ImageFileSpecification.class,  new ImageFileFactoryImpl());
		AbstractFileFactory.registerFileType(WordFileSpecification.class,  new WordFileFactoryImpl());
	}
}
