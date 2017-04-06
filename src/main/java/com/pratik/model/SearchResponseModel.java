package com.pratik.model;

import java.util.Map.Entry;
import java.util.Set;

public class SearchResponseModel {
	
	private Set<Entry<String, Integer>> counts;

	public SearchResponseModel(Set<Entry<String, Integer>> counts) {
		super();
		this.counts = counts;
	}
	public SearchResponseModel(){}
	
	public Set<Entry<String, Integer>> getCounts() {
		return counts;
	}

	public void setCounts(Set<Entry<String, Integer>> counts) {
		this.counts = counts;
	}

}
