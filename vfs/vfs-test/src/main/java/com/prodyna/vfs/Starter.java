package com.prodyna.vfs;

import com.prodyna.vfs.model.Folder;
import com.prodyna.vfs.model.spec.ImageFileSpecification;
import com.prodyna.vfs.model.spec.PDFFileSpecification;
import com.prodyna.vfs.model.spec.WordFileSpecification;

public class Starter {

	public static void main(String[] args) {
        FileManager fileManager = FileManagerFactory.getInstance();
        
        Folder root = fileManager.getRoot();
        fileManager.addFile(root, "bla", new String("xxx").getBytes(), new WordFileSpecification());
        Folder subFolder = fileManager.addFolder(root, "SubFolder");
        fileManager.register(subFolder, new FileSystemListener() {
			
			public void eventCallback(FileSystemEvent event) {
				System.out.println("event recieved: " + event);
				
			}
		});
        fileManager.addFile(subFolder, "bla2", new String("yyy").getBytes(), new PDFFileSpecification());
        fileManager.addFile(subFolder, "bla3", new String("zzz").getBytes(), new ImageFileSpecification());

        subFolder = fileManager.addFolder(subFolder, "SubSubFolder");
        fileManager.addFile(subFolder, "bla4", new String("yyy").getBytes(), new PDFFileSpecification());
        fileManager.addFile(subFolder, "bla5", new String("zzz").getBytes(), new ImageFileSpecification());
        
        fileManager.list();
	}

}
