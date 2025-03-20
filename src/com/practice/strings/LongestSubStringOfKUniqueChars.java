package com.practice.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubStringOfKUniqueChars {

	public static void main(String[] args) {
		String input = "aabaaab";
		int k = 2;
		int len = getLongestSubstringLength(input, k);
		System.out.println(len);
	}

	private static int getLongestSubstringLength(String input, int k) {
		Map<Character,Integer> map = new HashMap<>();
		Queue<Character> queue = new LinkedList<Character>();
		int j = 0;
		int max = -1;
		int i;
		for(i=0;i<input.length();i++) {
			if(!map.containsKey(input.charAt(i))){
				if(queue.size()==k) {
					max = Math.max(max, i-j);
					char removed = queue.poll();
					j = map.remove(removed)+1;
				}
				queue.add(input.charAt(i));
			}
			map.put(input.charAt(i), i);
		}
		if(queue.size()<k)
			return -1;
		return Math.max(max, i-j);
	}

}
