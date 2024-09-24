package com.dsa;

import java.util.HashMap;

public class Anagram {

	public static void main(String[] args) {
		String strOne = "tata";
		String strTwo = "atat";
		if(areAnagrams(strOne,strTwo)) {
			System.out.println("Yes. "+strOne+" and "+strTwo+" are anagrams.");
		}else {
			System.out.println("No. "+strOne+" and "+strTwo+" are not anagrams.");
		}

	}

	/*
	 *O(n) solution 
	 */
	private static boolean areAnagrams(String strOne, String strTwo) {
		if(strOne.length()!=strTwo.length())
			return false;
		HashMap<Character,Integer> map = new HashMap<>();
		/*for(int i=0;i<strOne.length();i++){
			map.put(strOne.charAt(i), map.getOrDefault(strOne.charAt(i),0)+1);
		}
		for(int i=0;i<strTwo.length();i++){
			if(map.containsKey(strTwo.charAt(i)))
				map.put(strTwo.charAt(i), map.get(strTwo.charAt(i))-1);
			else
				return false;
		}
		for(Character c : map.keySet()) {
			if(map.get(c)!=0)
				return false;
		}*/
		
		for(char c : strOne.toCharArray()) {
			map.compute(c, (k,v) -> v==null ? 1 : v+1);
		}
		
		System.out.println(map);
		
		for(char c : strTwo.toCharArray()) {
			map.compute(c, (k,v) -> v==1 ? null : v-1);
		}
		System.out.println(map);				
		
		if(map.isEmpty())
			return true;
		return false;
	}

	/*
	 * O(nlogn) complexity solution
	 * private static boolean areAnagrams(String strOne, String strTwo) {
		if(strOne.length()!=strTwo.length())
			return false;
		char[] one = strOne.toCharArray();
		char[] two = strTwo.toCharArray();
		Arrays.sort(one);
		Arrays.sort(two);
		for(int i=0;i<strOne.length();i++){
			if(one[i]!=two[i])
				return false;
		}
		return true;
	}*/

}
