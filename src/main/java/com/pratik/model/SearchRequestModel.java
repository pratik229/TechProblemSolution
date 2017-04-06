package com.pratik.model;

import java.util.ArrayList;
import java.util.List;

public class SearchRequestModel {
	List<String> searchText = new ArrayList<String>();
	
	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}

	public SearchRequestModel(List<String> searchText){
		this.searchText = searchText;
	}
	
	public SearchRequestModel(){
	}

}
