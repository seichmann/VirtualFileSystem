package com.prodyna.vfs;

import java.util.List;

import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.spec.WordFileSpecification;

public class Starter {

	public static void main(String[] args) {
		FileManager fileManager = FileManagerFactory.getInstance();
		
		Folder root = fileManager.getRoot();
		fileManager.addFile(root, "bla", new String("xxx").getBytes(), new WordFileSpecification() {
		});
		
		List<Node> children = fileManager.getChildren(root);
		
		System.out.println(children);
	}

}
