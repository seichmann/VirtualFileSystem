package com.prodyna.vfs.search.visitor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.prodyna.vfs.BaseSystemVisitor;
import com.prodyna.vfs.FileSystemRegistry;
import com.prodyna.vfs.filesystem.FileSystem;
import com.prodyna.vfs.model.AudioFileImpl;
import com.prodyna.vfs.model.FileImpl;
import com.prodyna.vfs.model.ImageFileImpl;
import com.prodyna.vfs.model.InternalFolderImpl;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.NodeImpl;
import com.prodyna.vfs.model.PDFFileImpl;
import com.prodyna.vfs.model.VideoFileImpl;
import com.prodyna.vfs.model.VirtualFolderImpl;
import com.prodyna.vfs.model.WordFileImpl;
import com.prodyna.vfs.search.SearchCriteria;

public class SearchVisitor extends BaseSystemVisitor {

	private SearchCriteria searchCriteria;
	private Set<NodeImpl> searchResult = new HashSet<NodeImpl>();

	public SearchVisitor(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	
	

	/**
	 * @return the searchResult
	 */
	public Set<Node> getSearchResult() {
		return Collections.unmodifiableSet((Set<? extends Node>)searchResult);
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.VideoFileImpl)
	 */
	@Override
	public void visit(VideoFileImpl file) {
		matchSearchCritera(file);
	}



	private void matchSearchCritera(NodeImpl file) {
		if (searchCriteria.match(file)) {
			searchResult.add(file);
		}
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.AudioFileImpl)
	 */
	@Override
	public void visit(AudioFileImpl file) {
		matchSearchCritera(file);
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.ImageFileImpl)
	 */
	@Override
	public void visit(ImageFileImpl file) {
		matchSearchCritera(file);
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.WordFileImpl)
	 */
	@Override
	public void visit(WordFileImpl file) {
		matchSearchCritera(file);
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.PDFFileImpl)
	 */
	@Override
	public void visit(PDFFileImpl file) {
		matchSearchCritera(file);
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.InternalFolderImpl)
	 */
	@Override
	public void visit(InternalFolderImpl virtualFolderImpl) {
		FileSystem fileSystem = FileSystemRegistry.getInstance().getFileSystem(virtualFolderImpl.getSystemType());
		matchSearchCritera(virtualFolderImpl);
		for (NodeImpl node : fileSystem.getChildren(virtualFolderImpl)) {
			node.accept(this);
		}
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.FileImpl)
	 */
	@Override
	public void visit(FileImpl fileImpl) {
		matchSearchCritera(fileImpl);
	}



	/* (non-Javadoc)
	 * @see com.prodyna.vfs.BaseSystemVisitor#visit(com.prodyna.vfs.model.VirtualFolderImpl)
	 */
	@Override
	public void visit(VirtualFolderImpl virtualFolderImpl) {
		matchSearchCritera(virtualFolderImpl);
	}
	
	
}
