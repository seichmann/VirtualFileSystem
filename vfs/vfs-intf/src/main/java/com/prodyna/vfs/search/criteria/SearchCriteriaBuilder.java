package com.prodyna.vfs.search.criteria;

import com.prodyna.vfs.model.Node;
import com.prodyna.vfs.search.SearchCriteria;

public class SearchCriteriaBuilder {
	
	SearchCriteria searchCriteria = new SearchCriteria() {
		
		public boolean match(Node node) {
			return true;
		}
	};

	SearchCriteriaBuilder and(SearchCriteria criteria) {
		searchCriteria = new AndSearchCriteria(searchCriteria, criteria);
		return this;
	}
	
	SearchCriteriaBuilder or(SearchCriteria criteria) {
		searchCriteria = new OrSearchCriteria(searchCriteria, criteria);
		return this;
	}
	
	public SearchCriteriaBuilder minSize(long size) {
		searchCriteria = new AndSearchCriteria(searchCriteria, new FileSearchCriteria(size, null));
		return this;
	}
	
	public SearchCriteriaBuilder maxSize(long size) {
		searchCriteria = new AndSearchCriteria(searchCriteria, new FileSearchCriteria(null, size));
		return this;
	}

	public SearchCriteriaBuilder sieBetween(long minSize, long maxSize) {
		searchCriteria = new AndSearchCriteria(searchCriteria, new FileSearchCriteria(minSize, maxSize));
		return this;
	}
	
	
	class AndSearchCriteria implements SearchCriteria{
		
		private SearchCriteria criteria1;
		private SearchCriteria criteria2;

		protected AndSearchCriteria(SearchCriteria criteria1, SearchCriteria criteria2){
			this.criteria1 = criteria1;
			this.criteria2 = criteria2;
		}
		
		public boolean match(Node node) {
			return criteria1.match(node) && criteria2.match(node);
		}
		
	}

	class OrSearchCriteria implements SearchCriteria {
		
		private SearchCriteria criteria1;
		private SearchCriteria criteria2;

		protected OrSearchCriteria(SearchCriteria criteria1, SearchCriteria criteria2){
			this.criteria1 = criteria1;
			this.criteria2 = criteria2;
		}
		
		public boolean match(Node node) {
			return criteria1.match(node) || criteria2.match(node);
		}
	}

	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}
	
	
}
