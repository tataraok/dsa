package com.practice.arrays;

import java.util.HashSet;

/**
 * Problem Statement:
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 * @author Tata Rao Karri
 *
 */
public class DuplicateChecker {

	public static void main(String[] args) {
		DuplicateChecker solution = new DuplicateChecker();
		boolean isDuplicateExists = solution.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2,1});
		if(isDuplicateExists)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
	 public boolean containsDuplicate(int[] nums) {
		 //Adding elements to set and finding duplicates give O(n) time and space complexity
		 HashSet<Integer> set = new HashSet<>();
		 for(int num : nums) {
			 if(!set.add(num)) {
				 return true;
			 }
		 }
		 return false;
		 
		 //Java stream gives O(n) space and time complexity just like set solution
		/* return Arrays.stream(nums).distinct().count()==nums.length ? false : true;*/
		 
		 //with time complexity nlogn but using same auxiliary array space.  
	/*	Arrays.sort(nums);
		for(int i=0;i<nums.length-1;i++) {
			 if(nums[i]==nums[i+1]) {
				 return true;
			 }
		 }
	     return false;  */
	 }

}
