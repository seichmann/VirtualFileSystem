package com.prodyna.vfs.search.criteria;

import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.search.SearchCriteria;

public class NameCriteria implements SearchCriteria {

	private String name;
	private boolean ignoreCase = false;
	
	public NameCriteria() {
	}

	public boolean match(Node node) {
		return ignoreCase ? node.getName().equalsIgnoreCase(name) :
			node.getName().equals(name);
	}

	public NameCriteria name(String name) {
		this.name = name;
		return this;
	}

	public NameCriteria ignoreCase() {
		this.ignoreCase = true;
		return this;
	}
	
}
