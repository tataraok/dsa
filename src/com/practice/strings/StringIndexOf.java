package com.practice.strings;

/*
 * Problem Statement:
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

 

Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.


 */
public class StringIndexOf {

	public static void main(String[] args) {
		StringIndexOf solution = new StringIndexOf();
		System.out.println(solution.strStr("sadbutsad", "sad"));
		System.out.println(solution.strStr("leetcode", "leeto"));
		System.out.println(solution.strStr("abcaaaabcdabca", "abcdabca"));
		System.out.println(solution.strStr("abbbbcaba", "bbc"));
		//LPS for pattern abcdabca : 0 0 0 0 1 2 3 1 

	}
	public int strStr(String main, String sub) {
		
		return optimalSubstringSearch(main, sub);
		//return bruteForceSubstringSearch(main,sub);
    }
	//KMP - Knuth-Morris-Pratt algo
	private int optimalSubstringSearch(String main, String sub) {
		int[] lps = getLPSOfPatternString(sub);
		int i = 0;
		int j = 0;
		while(i < main.length() && j < sub.length()) {
			if(sub.charAt(j)==main.charAt(i)) {
				i++;
				j++;
			}else if(j!=0) {
				j = lps[j-1];
			}else {
				i++;
			}
		}
		if(j==sub.length())
			return i-sub.length();
		return -1;
	}
	private int[] getLPSOfPatternString(String string) {
		int lps[] = new int[string.length()];
		int i = 0;
		int j = 1;
		while(i < string.length() && j < string.length()) {
			if(string.charAt(i)==string.charAt(j)) {
				lps[j] = i+1;
				i++;
				j++;
			}else if(i!=0) {
				i = lps[i-1];
			}else {
				j++;
			}
		}
		return lps;
	}
	private int bruteForceSubstringSearch(String mainString, String subString) {
		//brute force approach
		int i=0;
		int j=0;
		while(i<mainString.length() && j<subString.length()) {
			if(subString.charAt(j)==mainString.charAt(i)) {
				j++;
				i++;
			}else if(i!=0) {
				i = i + 1 - j ;
				j=0;
			}else {
				i++;
			}
			
		}
		
		if(j==subString.length())
			return i-subString.length();
		
		return -1;
	}
	

}
