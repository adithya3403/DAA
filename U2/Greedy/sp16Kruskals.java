// sp16 SpanningTrees Using Kruskals

/*

Budget Padmanabham planned to visit the tourist places.
There are N tourist places in the city.
The tourist places are numbered from 0 to N-1.
You are given the routes[] to travel between the tourist places in the city.
where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
You can travel from place-1 to place-2 or place-2 to place-1 with the given price.
Your task is to help Budget Padmanabham to find the cheapest route plan,
to visit all the tourist places in the city. 
If you are not able to find such plan, print -1.

Input Format:
Line-1: Two space separated integers N and R,number of places and routes.
Next R lines: Three space separated integers, start, end and price.
Output Format:
Print an integer, minimum cost to visit all the tourist places.

Sample Input-1:
4 5
0 1 3
0 2 5
1 2 4
2 3 1
1 3 5
Sample Output-1:
8
Explanation:
The cheapest route plan is as follows:
0-1, 1-2, 2-3 and cost is 3 + 4 + 1 = 8

Sample Input-2:
4 3
0 1 2
0 2 4
1 2 3
Sample Output-2:
-1

*/

import java.util.*;

class Route {
    int start, end, weight;

    Route(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class sp16Kruskals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Route[] arr = new Route[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            arr[i] = new Route(start, end, weight);
        }
        System.out.println(kruskals(arr, m, n));
        sc.close();
    }

    static int kruskals(Route[] arr, int m, int n) {
        Arrays.sort(arr, (a, b) -> a.weight - b.weight);
        int[] parent = new int[m];
        for (int i = 0; i < m; i++)
            parent[i] = i;
        int cost = 0, count = 0;
        for (int i = 0; i < n; i++) {
            int start = arr[i].start;
            int end = arr[i].end;
            int weight = arr[i].weight;
            int sP = find(parent, start);
            int eP = find(parent, end);
            if (sP != eP) {
                parent[sP] = eP;
                cost += weight;
                count++;
            }
        }
        if (count == m - 1)
            return cost;
        return -1;
    }

    static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent, parent[x]);
    }
}