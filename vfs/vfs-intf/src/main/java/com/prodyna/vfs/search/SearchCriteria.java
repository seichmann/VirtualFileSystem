package com.prodyna.vfs.search;

import com.prodyna.vfs.model.Node;

public interface SearchCriteria {

	boolean match(Node node);

}
