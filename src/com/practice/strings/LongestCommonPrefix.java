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
		System.out.println(solution.longestCommonPrefix(new String[] {"flower","flow","flight"}));
		System.out.println(solution.longestCommonPrefix(new String[] {"dog","racecar","car"}));

	}
	public String longestCommonPrefix(String[] strs) {
		StringBuilder builder = new StringBuilder();
		int maxCommonPrefxSize = Integer.MAX_VALUE;
		for(String s : strs) {
			maxCommonPrefxSize = Math.min(maxCommonPrefxSize, s.length());
		}
		int a;
		for(int i=0;i<maxCommonPrefxSize;i++) {
			a = -1;
			for(int j=0;j<strs.length;j++) {
				if(a!=-1 && a!=(int)strs[j].charAt(i))
					return builder.toString();
				else
					a = (int)strs[j].charAt(i);
				if(j==strs.length-1)
					builder.append(strs[j].charAt(i));
			}
			
		}
        return builder.toString();
    }

}
