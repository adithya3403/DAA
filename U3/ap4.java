// ap4 TreasureHunt

/*

Mahalakshmi participated in a treasure-hunt conatins N boxes in it.
Each box is numbered from 0,1,2,3,...,N-1. 
All the boxes are intially locked with the passcodes, except Box-0.
The passcode is written in a envolope and marked with its concern box number.

Each box in the treasure hunt contains a list of envelopes, which has passcodes 
to open the other boxes. You can open the boxes in any order, but you have to
start from box-0 intially.

The rule to win the treasure-hunt is to open all the boxes.
Your task is to find out, whether Mahalakshmi win the treasure hunt or not.
If she win, print "Win".
Otherwise, print "Lost"

Input Format:
-------------
Line-1: An integer, number of boxes.
Next N lines: space separated integers, box numbers.

Output Format:
--------------
Return a boolean value, "true"-> "Win" and "false" -> "Lost" 


Sample Input-1:
---------------
5
1
2
3
4
3

Sample Output-1:
----------------
Win


Sample Input-2:
---------------
4
1 3
3 0 1
2
0

Sample Output-2:
----------------
Lost

*/

import java.util.*;

class ap4 {
    public boolean canOpenAllBoxes(List<List<Integer>> boxes) {
        // implement your code here.
        boolean[] visited = new boolean[boxes.size()];
        visited[0] = true;
        dfs(boxes, visited, 0);
        for (boolean b : visited)
            if (!b)
                return false;
        return true;
    }

    void dfs(List<List<Integer>> boxes, boolean[] visited, int i) {
        for (int k : boxes.get(i)) {
            if (visited[k] == false) {
                visited[k] = true;
                dfs(boxes, visited, k);
            }
        }
    }
}
