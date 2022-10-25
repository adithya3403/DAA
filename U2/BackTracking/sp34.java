// sp34 MaxGold

/*

The Kolar Gold Fields (KGF) is in the form of a m*n grid,
Each field, contains some amount of Gold in it.
 
You can mine the gold in the KGF in the following way.
	- You can start at any position in the grid, never visit a cell with no gold.
	- each time you visit a cell, you will grab all the gold in it.
	- You can move one step to the left, right, up or down.
	- You can't visit the same cell more than once.
	- You can stop at any cell.
	
Your task is to find the maximum amount of gold you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the KGF grid.
Next M lines: N space separated integers, gold in each row of the grid.

Output Format:
--------------
Print an integer, maximum amount of gold.


Sample Input-1:
---------------
3 3
0 6 0
5 8 7
0 9 0

Sample Output-1:
----------------
24

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 9 -> 8 -> 7.


Sample Input-2:
---------------
5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20

Sample Output-2:
----------------
28

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7

*/

class sp34 {
    public int getMaximumGold(int[][] grid) {
        // Implement your logic here.
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int d = dfs(grid, i, j);
                    max = Math.max(max, d);
                }
            }
        }
        return max;
    }

    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;
        int temp = grid[i][j];
        grid[i][j] = 0;
        int a = dfs(grid, i + 1, j);
        int b = dfs(grid, i - 1, j);
        int c = dfs(grid, i, j + 1);
        int d = dfs(grid, i, j - 1);
        int e = Math.max(a, b);
        int f = Math.max(c, d);
        int g = Math.max(e, f);
        grid[i][j] = temp;
        return temp + g;
    }
}