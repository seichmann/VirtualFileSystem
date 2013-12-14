package com.prodyna.vfs;

import javax.imageio.spi.ServiceRegistry;

public final class FileManagerFactory {
	
	private static FileManager INSTANCE;
	
	private FileManagerFactory() {
	}
	
	public static synchronized FileManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = ServiceRegistry.lookupProviders(FileManager.class).next();
		}
		
		return INSTANCE;
	}
}
