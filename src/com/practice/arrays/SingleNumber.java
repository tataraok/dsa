package com.practice.arrays;

/**
 * Problem Statement:
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 

Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1

 

Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.


 * @author Tata Rao Karri
 *
 */
public class SingleNumber {

	public static void main(String[] args) {
		SingleNumber solution = new SingleNumber();
		System.out.println(solution.singleNumber(new int[] {2,2,1}));
		System.out.println(solution.singleNumber(new int[] {4,1,2,1,2}));
		System.out.println(solution.singleNumber(new int[] {1}));

	}
	
	/*
	 * This solution used Hashset, so that extra space used - hence space complexity will be O(n)
	 * Time complexity is O(n)  as we are iterating through entire array and add & remove operations takes constant time O(1) which does not increase the time complexity significantly.
	 * 
	 * 
	public int singleNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for(int i=0;i<nums.length;i++) {
			if(!set.add(nums[i])) {
				set.remove(nums[i]);
			}
		}
        return set.iterator().next();
    }
	
	*/
	
	/*
	 * The sane program can be optimized at space level. Instead of using hashset data structure, we can use XOR (^) which returns same number when we do XOR with 0, 
	 * and returns 0 when we do XOR on itself.
	 * Ex : 2 ^ 0 = 2
	 *      3 ^ 3 = 3
	 *      4 ^ 1 ^ 2 ^ 1 ^ 2 = 4
	 */
	public int singleNumber(int[] nums) {
		int result = 0;
		for(int number : nums) {
			result ^= number;
			//System.out.println("result: "+result+" number: "+number);
		}
        return result;
    }

}
