package com.practice.strings;
/*
 * Problem Statement:
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

 

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lowercase English letters.


 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		LongestCommonPrefix solution = new LongestCommonPrefix();
		System.out.println(solution.longestCommonPrefixOptimal(new String[] {"flower","flow","flight"}));
		System.out.println(solution.longestCommonPrefixOptimal(new String[] {"dog","racecar","dar"}));

	}
	public String longestCommonPrefix(String[] strs) {
		StringBuilder builder = new StringBuilder();
		int maxCommonPrefxSize = Integer.MAX_VALUE;
		for(String s : strs) {
			maxCommonPrefxSize = Math.min(maxCommonPrefxSize, s.length());
		}
		char c = '\0';
		for(int i=0;i<maxCommonPrefxSize;i++) {
			for(int j=0;j<strs.length;j++) {
				if(j!=0 && c!=strs[j].charAt(i))
					return builder.toString();
				else if(j==0)
					c = strs[j].charAt(i);
				if(j==strs.length-1)
					builder.append(c);
			}
			
		}
        return builder.toString();
    }
	
	//100% beats in time complexity in leetcode
	public String longestCommonPrefixOptimal(String[] strs) {
		if(strs==null || strs.length==0) return "";
		String prefix = strs[0];
		for(int i=1;i<strs.length;i++) {
			while(!strs[i].startsWith(prefix)) {
				prefix = prefix.substring(0,prefix.length()-1);
			}
		}
        return prefix;
    }

}
