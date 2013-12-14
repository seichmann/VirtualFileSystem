package com.prodyna.vfs.filesystem;

import com.prodyna.vfs.FileSystemEvent;
import com.prodyna.vfs.FileSystemEventEnum;
import com.prodyna.vfs.model.Node;

public class FileSystemEventImpl implements FileSystemEvent {

	private Node node;
	private FileSystemEventEnum eventType;

	public FileSystemEventImpl(Node node, FileSystemEventEnum eventType) {
		this.node = node;
		this.eventType = eventType;
	}

	/**
	 * @return the node
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * @return the eventType
	 */
	public FileSystemEventEnum getEventType() {
		return eventType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileSystemEventImpl [node=" + node + ", eventType=" + eventType
				+ "]";
	}
	
	

}
