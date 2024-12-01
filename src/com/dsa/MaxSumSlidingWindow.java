package com.dsa;

import java.util.Arrays;
import java.util.List;

public class MaxSumSlidingWindow {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 5, 2, 3, 4, 2, 6);
		int k = 3;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (i >= k) {
				sum = sum - list.get(i - k) + list.get(i);
				max = Math.max(max, sum);
			} else {
				sum += list.get(i);
			}			
		}
		System.out.println("Max adjacent array is : " + Math.max(max, sum));
	}

}
