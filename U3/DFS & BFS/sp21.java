// sp21 LargestSaplingGroup

/*

Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or 
diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.


Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

*/

import java.util.*;

class sp21 {
    void solve(int[][] gridland) {
        // implement your code here.
        int max = 0;
        for (int i = 0; i < gridland.length; i++) {
            for (int j = 0; j < gridland[0].length; j++) {
                if (gridland[i][j] == 1) {
                    // int count=dfs(gridland, i, j);
                    int count = bfs(gridland, i, j);
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }

    static int dfs(int[][] arr, int i, int j) {
        if (i >= arr.length || j >= arr[0].length || i < 0 || j < 0 || arr[i][j] == 0)
            return 0;
        arr[i][j] = 0;
        int c = 1;
        c += dfs(arr, i - 1, j);
        c += dfs(arr, i + 1, j);
        c += dfs(arr, i, j - 1);
        c += dfs(arr, i, j + 1);
        c += dfs(arr, i + 1, j + 1);
        c += dfs(arr, i - 1, j - 1);
        c += dfs(arr, i + 1, j - 1);
        c += dfs(arr, i - 1, j + 1);
        return c;
    }

    static int bfs(int[][] arr, int i, int j) {
        int c = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            if (x >= arr.length || y >= arr[0].length || x < 0 || y < 0 || arr[x][y] == 0)
                continue;
            arr[x][y] = 0;
            c++;
            q.add(new int[] { x - 1, y });
            q.add(new int[] { x + 1, y });
            q.add(new int[] { x, y - 1 });
            q.add(new int[] { x, y + 1 });
            q.add(new int[] { x + 1, y + 1 });
            q.add(new int[] { x - 1, y - 1 });
            q.add(new int[] { x + 1, y - 1 });
            q.add(new int[] { x - 1, y + 1 });
        }
        return c;
    }
}
