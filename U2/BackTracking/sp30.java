// sp30 NQueens

/*

Akbar used to play chess with Birbal almost every evening.
Once Akbar has challanged Birbal to place the queens in each row of the board,
such that no queen should attack another queen on the board.

You are given an integer N, indicates the size of the board as N*N.
Your task is to help Birbal to find and win in this challange, 
if there is a solution, print the answer as shown in the samples
Otherwise, print "No Solution"

Input Format:
-------------
An integer N, size of the chess board.

Output Format:
--------------
Print any possible solution.


Sample Input-1:
---------------
4

Sample Output-1:
----------------
0010
1000
0001
0100



Sample Input-2:
---------------
3

Sample Output-2:
----------------
No Solution

*/

class sp30 {
    int N;

    void solveNQ() {
        // implement your logic here.
        int[][] board = new int[N][N];
        if (!solveNQUtil(board, 0, 0)) {
            System.out.println("No Solution");
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    System.out.print(board[i][j]);
                System.out.println();
            }
        }
    }

    boolean solveNQUtil(int[][] board, int r, int c) {
        if (r == N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, r, i)) {
                board[r][i] = 1;
                if (solveNQUtil(board, r + 1, 0))
                    return true;
                board[r][i] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int[][] board, int r, int c) {
        for (int i = 0; i < N; i++)
            if (board[r][i] == 1)
                return false;
        for (int i = 0; i < N; i++)
            if (board[i][c] == 1)
                return false;
        for (int i = r, j = c; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (int i = r, j = c; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;
        return true;
    }
}