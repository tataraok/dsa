package com.practice.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class DuplicateChecker {

	public static void main(String[] args) {
		DuplicateChecker solution = new DuplicateChecker();
		boolean isDuplicateExists = solution.containsDuplicate(new int[] {1,2,3,5});
		if(isDuplicateExists)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
	 public boolean containsDuplicate(int[] nums) {
		 //Adding elements to set and finding duplicates give O(n) time and space complexity
		 HashSet<Integer> set = new HashSet<>();
		 for(int i=0;i<nums.length;i++) {
			 if(!set.add(nums[i])) {
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
