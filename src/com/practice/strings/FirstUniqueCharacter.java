package com.practice.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Problem Statement:
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

 

Constraints:

    1 <= s.length <= 105
    s consists of only lowercase English letters.


 */
public class FirstUniqueCharacter {

	public static void main(String[] args) {
		FirstUniqueCharacter solution = new FirstUniqueCharacter();
		//int index = solution.firstUniqChar("loveleetcode");
		int index = solution.firstUniqChar("leetcode");
		//int index = solution.firstUniqChar("aadadaad");
		//int index = solution.firstUniqChar("aabb");
		if(index==-1) {
			System.out.println("No non-repeating character found");
		}else {
			System.out.println("First Unique character found at index = "+index);
		}

	}
	
	public int firstUniqChar(String s) {
		int[] frequency = new int[26];
		for(char c : s.toCharArray()) {
			frequency[c-'a']++;
		}
		for(int i=0;i<s.length();i++) {
			if(frequency[s.charAt(i) - 'a']==1) {
				return i;
			}			
		}
		return -1;
    }
	
	//Using Map - O(n) time and space complexity
	/*public int firstUniqChar(String s) {
		Map<Character,Integer> map = new HashMap<>();
		for(char c : s.toCharArray()) {
			map.compute(c, (k,v)-> v==null? 1: v+1);
		}
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i))==1) {
				return i;
			}			
		}
		return -1;
    }
	*/

}
