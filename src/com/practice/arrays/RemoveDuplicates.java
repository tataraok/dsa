package com.practice.arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int uniqueElements = solution.removeDuplicates(new int[] {1,1,2,2,3,4,4,4});
		System.out.println(uniqueElements);

	}

}
class Solution {
	//Returns number of unique elements in a given array with in-place technique 
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                i++;
                nums[i]=nums[j];
            }
        }
        return ++i;
    }
}
