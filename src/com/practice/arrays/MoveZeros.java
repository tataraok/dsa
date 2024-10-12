package com.practice.arrays;

/*
 * Problem Statement:
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]

 

Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1
 Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeros {

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		MoveZeros solution = new MoveZeros();
		solution.moveZeroes(nums);
		ArraysUtil.print(nums);
		
		nums = new int[] { 0 };
		solution.moveZeroes(nums);
		ArraysUtil.print(nums);
		
		nums = new int[] { 1,0,2,3,0 };
		solution.moveZeroes(nums);
		ArraysUtil.print(nums);
		nums = new int[] { 1,0,0,0,10,0,0,1 };
		solution.moveZeroes(nums);
		ArraysUtil.print(nums);
	}

	public void moveZeroes(int[] nums) {
		int i=0;
	    int j=0;
	    while(i<nums.length && j<nums.length-1) {
	    	 if(i<=j) {
	    		 j++;
	    	 }
	    	 if(nums[i]==0 && nums[j]!=0) { 
	    		 int temp = nums[i];
	    		 nums[i] = nums[j];
	    		 nums[j] = temp;
	    	 }
	    	 if(nums[i]!=0)
	    		 i++;
	     }
	 }

}
