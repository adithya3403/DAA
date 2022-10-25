// sp33 BCS

/*

Given an integer value N, indicates number of bits in a binary number.

Your task is to design a Binary Code System, where two consecutive values
in BCS having N bits, must have one bit difference only.
(For example refer the sample testcases.)

Find and print the integer values of BCS, starting from 0.


Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3

Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

*/

import java.util.*;

class BSC {
    public List<Integer> bcs(int n) {
        // Implement your logic here.
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        List<Integer> prev = bcs(n - 1);
        res.addAll(prev);
        for (int i = prev.size() - 1; i >= 0; i--) {
            res.add(prev.get(i) + (int) Math.pow(2, n - 1));
        }
        return res;
    }
}
