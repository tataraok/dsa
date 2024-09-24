package com.dsa;

import java.util.HashMap;
import java.util.Map;

public class SumOfTwo {

	public static void main(String[] args) {
		int target = 18;
		int[] array = new int[] {2,7,11,15};
		int[] indices = getIndeciesSumOfTwo(array,target);
		if(indices==null) {
			System.out.println("No such pair found to sum up to target: "+target);
		}else {
			System.out.println(String.format("Indices: { %d,%d }",indices[0],indices[1]));
		}

	}

	private static int[] getIndeciesSumOfTwo(int[] array, int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<array.length;i++) {
			map.put(array[i], i);
		}
		for(int i=0;i<array.length;i++) {
			if(map.get(target-array[i])!=null && map.get(target-array[i])!=i) {
				return new int[] {i,map.get(target-array[i])};
			}
		}
		return null;
	}

}
