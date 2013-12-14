package com.prodyna.vfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.prodyna.vfs.model.Node;

public class FileSystemEventHelper implements Observable {
	
	private Map<Node, Set<FileSystemListener>> listenerRegistry = new HashMap<Node, Set<FileSystemListener>>();

	public void register(Node node, FileSystemListener listener) {
		Set<FileSystemListener> listenerSet = listenerRegistry.get(node);
		
		if (listenerSet == null) {
			listenerSet = new HashSet<FileSystemListener>();
			listenerRegistry.put(node, listenerSet);
		}
		
		listenerSet.add(listener);
	}

	public void unRegister(Node node, FileSystemListener listener) {
		Set<FileSystemListener> listenerSet = listenerRegistry.get(node);
		
		if (listenerSet == null) {
			return;
		}
		
		listenerSet.remove(listener);
	}

	public void fireEvent(FileSystemEvent event) {
		Node node = event.getNode();
		Set<FileSystemListener> listenerSet = listenerRegistry.get(node);
		if (listenerSet != null) {
			for (FileSystemListener listener : listenerSet) {
				listener.eventCallback(event);
			}
		}
	}
}
