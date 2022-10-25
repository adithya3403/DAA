// sp18 SingleSource

/*

Given N satellite stations, numbered 0 to N-1.
These satellites are connected to send signals from one to other.
To send a signal from satellite 's' to satellite 'd', 
it takes an amount of time 't'.

You are given a grid of travel times as times[][], where times[s][d] 
is the value of time 't' required to send a signal from 's' to 'd' or 'd' to 's'

Your task to find the time taken to recieve signal from a satellite station-0 
to all N-1 satellite stations and print them as a list.
i.e. time taken from 0 to 0, time taken from 0 to 1, time taken from 0 to 2,
... , time taken from 0 to N-1.


Input Format:
-------------
Line-1 -> An integer, N number of satellite stations
Next N lines -> N space separated integers, times[][]

Output Format:
--------------
Print the list of integers, times[].


Sample Input-1:
---------------
5
0 1 3 15 4
1 0 9 3 14
3 9 0 3 15
15 3 3 0 10
4 14 15 10 0

Sample Output-1:
----------------
[0, 1, 3, 4, 4]


Sample Input-2:
---------------
6
0 0 0 9 11 10
0 0 10 5 9 3
0 10 0 5 8 15
9 5 5 0 8 2
11 9 8 8 0 15
10 3 15 2 15 0

Sample Output-2:
----------------
[0, 13, 14, 9, 11, 10]

*/

import java.util.*;

public class sp18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(last(arr, n));
        sc.close();
    }

    static List<Integer> last(int[][] arr, int n) {
        int[] dist = new int[n];
        dist[0] = 0;
        for (int i = 1; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    minIndex = j;
                }
            }
            visited[minIndex] = true;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && arr[minIndex][j] != 0 && dist[minIndex] != Integer.MAX_VALUE
                        && dist[minIndex] + arr[minIndex][j] < dist[j]) {
                    dist[j] = dist[minIndex] + arr[minIndex][j];
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(dist[i]);
        }
        return result;
    }
}