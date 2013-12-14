package com.prodyna.vfs.search.criteria;

import com.prodyna.vfs.model.File;
import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.model.NodeType;
import com.prodyna.vfs.search.SearchCriteria;

public class FileSearchCriteria implements SearchCriteria {

	private Long minSize;
	private Long maxSize;


	public boolean match(Node node) {
		if (node.getType() != NodeType.FILE) {
			return false;
		}
		File file = (File) node;
		return (minSize == null || file.getSize() >= minSize.longValue())
				&& (maxSize == null || file.getSize() <= maxSize.longValue());
	}

	public FileSearchCriteria (Long minSize, Long maxSize) {
		this.minSize = minSize;
		this.maxSize = maxSize;
	}
}
