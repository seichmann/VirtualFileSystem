package com.prodyna.vfs;

import com.prodyna.vfs.model.Node;

public interface FileSystemEvent {

	Node getNode();
	
	FileSystemEventEnum getEventType();
	
}
