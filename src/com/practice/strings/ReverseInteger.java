package com.practice.strings;

/*
 * Proble Statement:
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

 

Constraints:

    -231 <= x <= 231 - 1

 */
public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger solution = new ReverseInteger();
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(-130));
		System.out.println(solution.reverse(1534236469));
		
	}
	public int reverse(int x) {
		int sum = 0;
		while(x!=0) {
			if(sum > Integer.MAX_VALUE/10 || sum < Integer.MIN_VALUE/10)
				return 0; 
			sum = (x%10)+ (sum*10);
			x /= 10;
		}
        return sum;
    }

}
