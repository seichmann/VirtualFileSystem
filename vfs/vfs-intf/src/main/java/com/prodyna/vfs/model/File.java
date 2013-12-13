package com.prodyna.vfs.model;

public interface File extends Node{

	byte[] getContent();
	
	int getSize();
}
