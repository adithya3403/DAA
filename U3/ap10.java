// ap10 Construct words

/*

Given an 2D character array, Letters[][], of size r*c.
You have to construct the word W, using the given array.

Rules to construct the word are as follows:
	- All the letters of the word W, should be adjacent to each other 
	in the array Letters(either horizontal or vertical).
	- You can use each charcater in Letters[][] only once.

If you are able to construct the word W, return 'true'
Otherwise 'false'.

Input Format:
-------------
Line-1 -> two integers R and C, array size.
R lines -> C space separated characters.
Last line -> a string, word W

Output Format:
--------------
print the boolean result.


Sample Input-1:
---------------
3 3
a b c
d e f
g h i
bad

Sample Output-1:
----------------
true

Sample Input-2:
---------------
3 3
a b c
d e f
g h i
ace

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 3
a b c
d e f
g h i
add

Sample Output-3:
----------------
false

*/

import java.util.*;

public class ap10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] letters = new char[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                letters[i][j] = sc.next().charAt(0);
        String w = sc.next();
        System.out.println(canConstruct(letters, w));
        sc.close();
    }

    static boolean canConstruct(char[][] letters, String w) {
        int r = letters.length;
        int c = letters[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                if (letters[i][j] == w.charAt(0))
                    if (dfs(letters, visited, i, j, w, 0))
                        return true;
        return false;
    }

    static boolean dfs(char[][] letters, boolean[][] visited, int i, int j, String w, int index) {
        if (index == w.length())
            return true;
        if (i < 0 || i >= letters.length
                || j < 0 || j >= letters[0].length
                || visited[i][j] || letters[i][j] != w.charAt(index))
            return false;
        visited[i][j] = true;
        if (dfs(letters, visited, i + 1, j, w, index + 1)
                || dfs(letters, visited, i - 1, j, w, index + 1)
                || dfs(letters, visited, i, j + 1, w, index + 1)
                || dfs(letters, visited, i, j - 1, w, index + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
}