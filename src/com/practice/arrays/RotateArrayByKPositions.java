package com.practice.arrays;
/**
 * Problem Statement:
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 * @author Tata Rao Karri
 *
 */
public class RotateArrayByKPositions {

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int[] nums = new int[] {1,2,3};
		int k = 1;
		System.out.println("Before rotation: ");
		ArraysUtil.print(nums);
		solution.rightRotate(nums, k);
		System.out.println("\nAfter right rotation: ");		
		ArraysUtil.print(nums);
		System.out.println("\nAfter left rotation: ");
		solution.leftRotate(nums, k);
		ArraysUtil.print(nums);
		System.out.println("\nAfter second left rotation: ");
		solution.leftRotate(nums, k);
		ArraysUtil.print(nums);

	}

}
class Solution2 {
	/*
	 * 
	 * using k*n complexity - rotating array in k times
	
	public void rightRotate(int[] nums, int k) {
		if(nums.length <= k)
			return;
		int dispElement;
		for(int i=0;i<k;i++) {
			dispElement = nums[nums.length-1];
			for(int j = nums.length-2;j>=0;j--) {
				nums[j+1] = nums[j];
			}
			nums[0] = dispElement;
		}
    }	
	
	public void leftRotate(int[] nums, int k) {
		if(nums.length <= k)
			return;
		int dispElement;
		for(int i=0;i<k;i++) {
			dispElement = nums[0];
			for(int j = 0;j<nums.length-1;j++) {
				nums[j] = nums[j+1];
			}
			nums[nums.length-1] = dispElement;
		}
    }*/
	public void rightRotate(int[] nums, int k) {
	    int n = nums.length;
        k = k%n;
       // if(k==0) return;
       /* reverse(nums,0,n-k-1);
	    reverse(nums,n-k,n-1);
	    reverse(nums,0,n-1); 
	           OR
	    */	        
		reverse(nums,0,n-1);
		reverse(nums,0,k-1);
		reverse(nums,k,n-1);
    }	 
	
	private void reverse(int[] nums, int start, int end) {
		while(start<end) {
			int t = nums[start];
			nums[start] = nums[end];
			nums[end] = t;
			start++;
			end--;
		}
		
	}

	public void leftRotate(int[] nums, int k) {
		int n = nums.length;
        k = k%n;
       // if(k==0) return;
		reverse(nums,0,k-1);
		reverse(nums,k,n-1);
		reverse(nums,0,n-1);
    }
}
