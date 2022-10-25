// sp10 MotuEatingSamosas

/*

Motu loves to eat Samosas. A Samosas vendor prepared N boxes of samosas, 
where i-th box contains box[i] samosas. And the samosas vendor went outside 
the shop, He will be back in T hours time.

Motu can decide his eating speed of samosas per hour as S.  
Each hour, He chooses any box of samosas, and eats S samosas from that box.  
If the box has less than S samosas, he eats all of them instead, 
and won't eat any more samosas during this hour.

Motu likes to eat slowly, but he wants to finish eating all the samosas 
before the vendor come back.

Can you help Motu to find out his minimum eating speed S,
such that he can eat all the samosas within T hours, and print S.

Note:
	- You may assume that the time T is always >= Number of boxes

Input Format:
-------------
Line-1: space separated integers, box[], number of samosas in each box
Line-2: An integer T.

Output Format:
--------------
Print an integer S, minimum eating speed of Motu.


Sample Input-1:
---------------
4 8 9 13
8

Sample Output-1:
----------------
5

Explanation:
-----------
With Eating speed of 5:
Motu eats 4 samosas in 1st box in 1st hour., remaining in 1st box 0
Motu eats 5 samosas from 2nd box in 2nd hour, remaining in 2nd box 3
Motu eats 3 samosas from 2nd box in 3rd hour, remaining in 2nd box 0
Motu eats 5 samosas from 3rd box in 4th hour, remaining in 3rd box 4
Motu eats 4 samosas from 3rd box in 5th hour, remaining in 3rd box 0
Motu eats 5 samosas from 4th box in 6th hour, remaining in 4th box 8
Motu eats 5 samosas from 4th box in 7th hour, remaining in 4th box 3
Motu eats 3 samosas from 4th box in 8th hour, remaining in 4th box 0.


Sample Input-2:
---------------
15 18 12 17 22
7

Sample Output-2:
----------------
17

*/

import java.util.*;

public class sp10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int n = str.length;
        int[] box = new int[n];
        for (int i = 0; i < n; i++) {
            box[i] = Integer.parseInt(str[i]);
        }
        int t = sc.nextInt();
        System.out.println(minSpeed(box, t));
        sc.close();
    }

    static int maximum(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    static int minSpeed(int[] box, int t) {
        int l = 1, r = maximum(box);
        while (l < r) {
            int mid = (l + r) / 2;
            if (isMin(box, t, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static boolean isMin(int[] box, int t, int mid) {
        int h = 0;
        for (int i = 0; i < box.length; i++) {
            h += (box[i] + mid - 1) / mid;
        }
        return h <= t;
    }
}