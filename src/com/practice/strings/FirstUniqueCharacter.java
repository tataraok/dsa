package com.practice.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
		int index = solution.firstUniqChar("leetcode");
		if(index==-1) {
			System.out.println("No non-repeating character found");
		}else {
			System.out.println("First Unique character found at index = "+index);
		}

	}
	public int firstUniqChar(String s) {
		Map<Character,List<Integer>> map = new LinkedHashMap<>();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i))) {
				map.get(s.charAt(i)).add(i);
			}else {
				List<Integer> indexes = new LinkedList<>();
				indexes.add(i);
				map.put(s.charAt(i), indexes);
			}
		}
		for(Character c : map.keySet()) {			
			if(map.get(c).size()==1) return map.get(c).get(0);
		}
		
		return -1;
    }

}
