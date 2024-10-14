package com.practice.arrays;

import java.util.HashSet;

/*
 * Problem Statement:
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

    A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    Only the filled cells need to be validated according to the mentioned rules.

 

Example 1:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 

Constraints:

    board.length == 9
    board[i].length == 9
    board[i][j] is a digit 1-9 or '.'.

 */
public class ValidSudoku {

	public static void main(String[] args) {
		ValidSudoku solution = new ValidSudoku();
	 System.out.println("Is valid sudoku ? " +solution.isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
	 ,{'6','.','.','1','9','5','.','.','.'}
	 ,{'9','8','.','.','.','.','6','.','.'}
	 ,{'8','.','.','.','6','.','.','.','3'}
	 ,{'4','.','.','8','.','3','.','.','1'}
	 ,{'7','.','.','.','2','.','.','.','6'}
	 ,{'.','6','.','.','.','.','2','8','.'}
	 ,{'.','.','.','4','1','9','.','.','5'}
	 ,{'.','.','.','.','8','.','.','7','9'}}));
	 System.out.println("\n");
	 System.out.println("Is valid sudoku ? " +solution.isValidSudoku(new char[][]{{'8','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'9','8','.','.','.','.','6','.','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'6','.','.','.','.','2','8','.','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}}));
	 
	/* System.out.println("........................");
	 System.out.println(solution.isValidSubSquareMatrix(new char[][]{{'8','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'9','8','.','.','.','.','6','.','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'6','.','.','.','.','2','8','.','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}}));
	 System.out.println(solution.isValidSubSquareMatrix(new char[][]{{'5','3','.','.','7','.','.','.','.'}
	 ,{'6','.','.','1','9','5','.','.','.'}
	 ,{'9','8','.','.','.','.','6','.','.'}
	 ,{'8','.','.','.','6','.','.','.','3'}
	 ,{'4','.','.','8','.','3','.','.','1'}
	 ,{'7','.','.','.','2','.','.','.','6'}
	 ,{'.','6','.','.','.','.','2','8','.'}
	 ,{'.','.','.','4','1','9','.','.','5'}
	 ,{'.','.','.','.','8','.','.','7','9'}}));*/

	}
	public boolean isValidSudoku(char[][] board) {
		HashSet<Character> row = new HashSet<>();
		HashSet<Character> column = new HashSet<>();
		boolean isValidSudoku = true;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board.length;j++) {
				if(board[i][j]!='.' && !row.add(board[i][j])) {
					isValidSudoku = false;
				}
				if(board[j][i]!='.' && !column.add(board[j][i])) {
					isValidSudoku = false;
				}
			}
			row.clear();
			column.clear();
		}
		
        return isValidSudoku && isValidSubSquareMatrix(board);
    }

	private boolean isValidSubSquareMatrix(char[][] board) {	
		HashSet<Character> subMat = new HashSet<>();
		int i = 0; 
		int j = 0;
		int x1 = 0;
		int y1 = 3;
		int x2 = 0;
		int y2 = 3;
		while(i<y1 && y1<=9) {
			j = x2;
			while(j<y2) {
				if(board[i][j]!='.' && !subMat.add(board[i][j])) {
					return false;
				}
				subMat.add(board[i][j]);
				j++;
			}
			i++;			
			if(i==y1) {
				if(y2<9) {
					x2 += 3;
					y2 += 3;					
				}else {
					x1 += 3;
					y1 += 3;
					x2 = 0;
					y2 = 3;						
				}
				i = x1;
				subMat.clear();
			}
		}
		return true;
	}

}
