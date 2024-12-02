package com.practice.strings;

/*
 * Problem Statement:
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

 

Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.


 */
public class ValidPalindrome {

	public static void main(String[] args) {
		ValidPalindrome solution = new ValidPalindrome();
		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(solution.isPalindrome("race a car"));
		System.out.println(solution.isPalindrome(" "));
		System.out.println(solution.isPalindrome("0P"));

	}
	public boolean isPalindrome(String s) {
		int i=0;
		int j = s.length()-1;
		while(i<j) {
			char start = s.charAt(i);
			char end = s.charAt(j);
			if(!Character.isLetterOrDigit(start)) {
				i++;
			}
			else if(!Character.isLetterOrDigit(end)) {
				j--;
			}else {
				if(Character.toLowerCase(start)!=Character.toLowerCase(end))
					return false;
				i++;
				j--;
			}
		}
        return true;
    }

}
