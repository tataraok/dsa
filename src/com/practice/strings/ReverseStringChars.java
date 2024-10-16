package com.practice.strings;
/*
 * Problem Statement:
 * Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

 

Constraints:

    1 <= s.length <= 105
    s[i] is a printable ascii character.


 */
public class ReverseStringChars {

	public static void main(String[] args) {
		ReverseStringChars solution = new ReverseStringChars();
		//char[] input = new char[] {'h','e','l','l','o'};
		char[] input = new char[] {'H','a','n','n','a','h'};
		solution.reverseString(input);
		for(char c: input) {
			System.out.print(c+" ");
		}
	}
	public void reverseString(char[] s) {
        int i=0;
        int n = s.length-1;
        while(i<=n) {
        	char c = s[i];
        	s[i] = s[n];
        	s[n] = c;
        	i++;
        	n--;
        }
    }
}
