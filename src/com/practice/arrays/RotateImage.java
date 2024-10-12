package com.practice.arrays;
/*
 * Problem Statement:
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Example 2:

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

Constraints:

    n == matrix.length == matrix[i].length
    1 <= n <= 20
    -1000 <= matrix[i][j] <= 1000

 */
public class RotateImage {

	public static void main(String[] args) {
		RotateImage solution = new RotateImage();
		//int[][] input = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		int[][] input = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println("Before: ");
		for(int i=0;i<input.length;i++) {
			ArraysUtil.print(input[i]);		
		}
		solution.rotate(input);
		System.out.println("After: ");
		for(int i=0;i<input.length;i++) {
			ArraysUtil.print(input[i]);		
		}

	}
	public void rotate(int[][] matrix) {
		transpose(matrix);
		mirrorColumns(matrix);
    }
	private void mirrorColumns(int[][] matrix) {
		int n = matrix.length;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n/2;j++) {
        		int t = matrix[i][j];
        		matrix[i][j] = matrix[i][n-1-j];
        		matrix[i][n-1-j] = t;
        	}
        }
	}
	private void transpose(int[][] matrix) {
		int n = matrix.length;
        for(int i=0;i<n;i++) {
        	for(int j=i;j<n;j++) {
        		int t = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = t;
        	}
        }
	}
}
