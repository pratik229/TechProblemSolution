package com.pratik.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.core.TextHandlerService;
import com.pratik.model.SearchRequestModel;
import com.pratik.model.SearchResponseModel;

@RestController
public class TextController {
	
	@Autowired
	private TextHandlerService textHandlerService;
	
	@RequestMapping(path="/counter-api/search", method=RequestMethod.POST)
	public SearchResponseModel searchWords(@RequestBody SearchRequestModel s){
		
		SearchResponseModel resp = new  SearchResponseModel(textHandlerService.getWordCount("text.txt", s.getSearchText()).entrySet());
		
		return resp;
	}
	
	@RequestMapping(path="/counter-api/top/{top}", method=RequestMethod.GET)
	public String topWords(@PathVariable(name="top") int top){
		
		return textHandlerService.getTopCount("text.txt", top);
					
	}

}
