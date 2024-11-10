package com.practice.strings;

import java.util.HashMap;

/*
 * Problem Statement:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

 */
public class ValidAnagram {

	public static void main(String[] args) {
		ValidAnagram solution = new ValidAnagram();
		System.out.println(solution.isAnagram("rat", "car"));
	}
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		HashMap<Character,Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.compute(c, (k,v) -> v==null ? 1 : v+1);
		}		
		
		for(char c : t.toCharArray()) {
			if(!map.containsKey(c)) return false;
			map.compute(c, (k,v) -> v==1 ? null : v-1);
		}			
		
		if(map.isEmpty())
			return true;
		return false;
    }

}
