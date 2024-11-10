package com.practice.strings;

public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger solution = new ReverseInteger();
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(-130));
		System.out.println(solution.reverse(1534236469));
		
	}
	public int reverse(int x) {
		int n = x < 0 ? -1*x : x;
		int sum = 0;
		int range = (int) Math.pow(2, 31);
		int rem;
		while(n>0) {
			rem = n%10;
			if(sum > (range/10 + (0.9 * rem)))
				return 0; 
			sum = rem+ (sum*10);
			n /= 10;
		}
		int converted = x < 0 ? -1*sum : sum;
        return converted;
    }

}
