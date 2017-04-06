package com.pratik.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

@Service
public class TextHandlerService {
	
	public Map<String, Integer> getWordCount(String fileName, List<String> wordsToBeSearched){
		
		Map<String, Integer> wMap = new HashMap<String, Integer>();
		
		//initialize the map
		for(String word:wordsToBeSearched)
			wMap.put(word.toLowerCase(), 0);
		
		//get handle to file and profile text for matching words
		BufferedReader br = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		//File file = new File(filePath);
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			String nextLine = "";
			
			while(null != (nextLine = br.readLine())){
				nextLine = nextLine.replace(".", "");
				nextLine = nextLine.replace(",", "");
				nextLine = nextLine.toLowerCase();
				StringTokenizer sTokenizer = new StringTokenizer(nextLine, " ");
				while(sTokenizer.hasMoreTokens()){
					String str = sTokenizer.nextToken();
					if(wMap.containsKey(str)){
						wMap.put(str, (wMap.get(str))+1);
					}
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{br.close();}catch(Exception e){}
		}
		
		
		return wMap;
		
	}
	
	
	public String getTopCount(String fileName, int top){
		
		Map<String, Integer> wMap = new HashMap<String, Integer>();
		
		//get handle to file and profile text for matching words
		BufferedReader br = null;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		//File file = new File(filePath);
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			String nextLine = "";
			
			while(null != (nextLine = br.readLine())){
				nextLine = nextLine.replace(".", "");
				nextLine = nextLine.replace(",", "");
				nextLine = nextLine.toLowerCase();
				StringTokenizer sTokenizer = new StringTokenizer(nextLine, " ");
				while(sTokenizer.hasMoreTokens()){
					String str = sTokenizer.nextToken();
					if(wMap.containsKey(str)){
						wMap.put(str, (wMap.get(str))+1);
					} else{
						wMap.put(str, 1);
					}
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{br.close();}catch(Exception e){}
		}
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>(new HashMapValueComparator(wMap));
		map.putAll(wMap);
		int i=0;
				
		String returnString = "";
		
		for(Entry<String, Integer> e:map.entrySet()){
			if(i == top) break;
			if(i!=0) returnString = returnString +" ";
			returnString = returnString + e.getKey()+"|"+e.getValue();
			i++;
		}
			
		return returnString;
		
	}

}

class HashMapValueComparator implements Comparator<String> {
    Map<String, Integer> map;

    public HashMapValueComparator(Map<String, Integer> map) {
        this.map = map;
    }

    public int compare(String key1, String key2) {
        if (map.get(key1) >= map.get(key2)) {
            return -1;
        } else {
            return 1;
        } 
    }
}
