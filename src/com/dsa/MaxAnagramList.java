package com.dsa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 
 * Output: Highest anagram combination
 */
public class MaxAnagramList {

	public static void main(String[] args) {
		String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

		Map<MyString, List<String>> map = new HashMap<>();
		for(String s : input) {
			MyString obj = new MyString(s);
			if(!map.containsKey(obj)) {
				List<String> temp = new ArrayList<>();
				temp.add(s);
				map.put(obj,temp);
			}else {
				//System.out.println(s);
				map.get(obj).add(s);
			}
		}
		String maxKey=null;
		int max = Integer.MIN_VALUE;
		for(Entry<MyString, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey().getValue()+" -> "+entry.getValue().toString());
			if(entry.getValue().size()>max) {
				max = entry.getValue().size();
				maxKey = entry.getKey().getValue();
			}
		}
		System.out.println("Max anagram size: "+max);
		System.out.println("Max anagram list: "+map.get(new MyString(maxKey)));
		
	}

	
	public static boolean areAnagrams(String str1, String str2) {
		if(str1.length()!=str2.length()) 
			return false;
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(char c : str1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(char c : str2.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)-1);
			if(map.get(c)==0)
				map.remove(c);
		}
		return map.isEmpty();
	}

}

class MyString {
	
	private String value;
	
	public MyString(String val) {
		value = val;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for(char c : value.toCharArray()) {
			result += prime * (int)c;
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyString other = (MyString) obj;
		return Objects.equals(value, other.value) ? true :MaxAnagramList.areAnagrams(value, other.value);
	}
	
}
