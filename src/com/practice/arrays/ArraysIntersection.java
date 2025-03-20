package com.practice.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem statement:
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.

 

Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

 */
public class ArraysIntersection {

	public static void main(String[] args) {
		ArraysIntersection solution = new ArraysIntersection();
		int[] result = solution.intersect(new int[] {1,2,2,1}, new int[] {2,2,2});
		ArraysUtil.print(result);
		result = solution.intersect(new int[] {4,9,5}, new int[] {9,9,4,8,4});
		ArraysUtil.print(result);
	}
	public int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> intersects = new ArrayList<>();		
		if(nums1.length<nums2.length) {
			getIntersectElements(nums1, nums2,intersects);
		}else{
			getIntersectElements(nums2, nums1,intersects);
		}
		int[] result = new int[intersects.size()];
		for(int i=0;i<result.length;i++) {
			result[i] = intersects.get(i);
		}
        return result; 
    }
	private List<Integer> getIntersectElements(int[] smallArray, int[] largeArray, List<Integer> intersects) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<largeArray.length;i++) {
			map.compute(largeArray[i], (k,v) -> v==null ? 1 : v+1);
		}
		for(int i=0;i<smallArray.length;i++) {
			if(map.containsKey(smallArray[i]) && map.get(smallArray[i])>0) {
				intersects.add(smallArray[i]);
				map.put(smallArray[i], map.get(smallArray[i])-1);
			}
			
		}
		return intersects;
	}

}
