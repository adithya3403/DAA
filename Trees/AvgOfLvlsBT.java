/*
For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
so on.
- At level-0: There will be only one bulb as root bulb.,
- From next level onwards, we can attach atmost two bulbs, one is to left side
and/or the other is to right side of every bulb in previous level.
- The empty attachements in a level are indicated with -1. 
(for example: look in hint)

You will be given the X-Mas Tree root,
Your task is to findout the average of voltages in each level of the X-Mas tree, 
starts from level-0.

Implement the class Solution.
1.public List<Double> averageOfLevels(BinaryTreeNode root): 
- returns a list of double values.


Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print a list of double values (averages of each level)



Sample Input-1:
---------------
3 8 4 3 5 -1 7 

Sample Output-1:
----------------
[3.0, 6.0, 5.0]


Sample Input-2:
---------------
3 8 4 3 5 7 7 

Sample Output-2:
----------------
[3.0, 6.0, 5.5]

*/

import java.util.*;

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    public List<Double> averageOfLevels(BinaryTreeNode root) {
        // Implement your code here.
        List<Double> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = q.poll();
                sum += node.data;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }
}

public class AvgOfLvlsBT {
    static BinaryTreeNode root;
    static BinaryTreeNode temp = root;

    void insert(BinaryTreeNode temp, int key) {
        if (temp == null) {
            root = new BinaryTreeNode(key);
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(temp);
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = new BinaryTreeNode(key);
                break;
            } else
                q.add(temp.left);
            if (temp.right == null) {
                temp.right = new BinaryTreeNode(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        AvgOfLvlsBT st = new AvgOfLvlsBT();
        root = new BinaryTreeNode(Integer.parseInt(str[0]));
        for (int i = 1; i < str.length; i++)
            st.insert(root, Integer.parseInt(str[i]));
        Solution sol = new Solution();
        System.out.println(sol.averageOfLevels(root));
        sc.close();
    }
}
