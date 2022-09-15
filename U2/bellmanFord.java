/*

Given N satellite stations, numbered 0 to N-1.
These satellites are connected to send signals from one to other.
To send a signal from satellite 's' to satellite 'd', 
it takes an amount of time 't'.

You are given a list of travel times as times[], where times[i]={s,d,t}
is the value of time 't' required to send a signal from 's' to 'd' or 'd' to 's'

Your task to find the time taken to recieve signal from a satellite station-0 
to all N-1 satellite stations and print them as a list.
i.e. time taken from 0 to 0, time taken from 0 to 1, time taken from 0 to 2,
... , time taken from 0 to N-1.

Note: Use BellmanFord algorithm


Input Format:
-------------
Line-1: Two space separated integers N and L,number of Satellite and Satellite links.
Next L lines: Three space separated integers, sourcr (s), destination (d) and time (t)

Output Format:
--------------
Print the list of integers, timetaken[].



Sample Input-1:
---------------
5 8
0 1 -1
0 2 4
1 2 3
1 3 3
1 4 2
3 2 5
3 1 1
4 3 -3

Sample Output-1:
----------------
[0, -1, 2, -2, 1]

*/

import java.util.*;

public class bellmanFord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        int l = sc.nextInt();
        int[][] times = new int[l][3];
        for (int i = 0; i < l; i++) {
            times[i][0] = sc.nextInt();
            times[i][1] = sc.nextInt();
            times[i][2] = sc.nextInt();
        }
        System.out.println(bellMan(times));
        sc.close();
    }

    static List<Integer> bellMan(int[][] times) {
        int n = times.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int w = times[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                res.add(dist[i]);
            }
        }
        return res;
    }
}