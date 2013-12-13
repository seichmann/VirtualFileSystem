package com.prodyna.vfs;

import javax.imageio.spi.ServiceRegistry;

public class FileManagerFactory {
	
	private static FileManager INSTANCE;
	
	public static synchronized FileManager getInstance() {
		if (INSTANCE == null) {
			INSTANCE = ServiceRegistry.lookupProviders(FileManager.class).next();
		}
		
		return INSTANCE;
	}
}
