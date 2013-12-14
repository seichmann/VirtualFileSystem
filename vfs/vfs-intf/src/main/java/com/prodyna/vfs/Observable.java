package com.prodyna.vfs;

import com.prodyna.vfs.model.Node;

public interface Observable {
	void register(Node node, FileSystemListener listener);
	void unRegister(Node node, FileSystemListener listener);
}
