package com.dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortMapByValues {

	public static void main(String[] args) {
		
		HashMap<String,Integer> hashMap = new HashMap<>();
		hashMap.put("banana",2);
		hashMap.put("apple",1);
		hashMap.put("mangoe",3);
		hashMap.put("grape",3);
		hashMap.put("orange",4);
		hashMap.forEach((key,value) -> System.out.println(key+" : "+value));
		List<Map.Entry> entries = new ArrayList<>(hashMap.entrySet());
		entries.sort((entry1,entry2) -> ((Integer)entry2.getValue()).compareTo((Integer)entry1.getValue()));
		final LinkedHashMap<Object,Object> map = new LinkedHashMap<>();
		entries.forEach(entry -> map.put(entry.getKey(), entry.getValue()));
		System.out.println("After sort");
		map.forEach((key,value) -> System.out.println(key+" : "+value));
		
	}

}
