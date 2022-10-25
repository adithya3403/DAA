// sp22 UniquePatterns

/*

Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in board.
Next M lines: contains N space-separated characters ['0','1'].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
   1			1 1		1 
1 1 1		   1  	,	1 1
   1		,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1			1 1 	,	1
1 		,  	   1 ,	     1 1 	,

*/

import java.util.*;

class sp22 {
    public int numUniquePatterns(int[][] board) {
        // Implement your code here
        Set<String> set = new HashSet<>();
        char[] dir = { 'u', 'd', 'l', 'r' };
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(board, i, j, sb, dir);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    static void dfs(int[][] arr, int i, int j, StringBuilder sb, char[] dir) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 0)
            return;
        arr[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            sb.append(k);
            switch (dir[k]) {
                case 'u':
                    dfs(arr, i - 1, j, sb, dir);
                    break;
                case 'd':
                    dfs(arr, i + 1, j, sb, dir);
                    break;
                case 'l':
                    dfs(arr, i, j - 1, sb, dir);
                    break;
                case 'r':
                    dfs(arr, i, j + 1, sb, dir);
                    break;
            }
        }
        sb.append('b');
    }
}