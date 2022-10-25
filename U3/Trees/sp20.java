// sp20 PersonIDs

/*

In a joint family, every person assigned with an ID, an integer value.
and the entire family is arranged in the from of tree.

You will be given the family tree,
your task is to find and print the person ID, who is only child to his/her parent.
i.e, the person with no siblings. Print all such person ID's in ascending order.

NOTE: 
- If only one person is there in the family, please consider him as a parent.
- In the given tree, please consider '-1' as null.

Input Format:
-------------
Single line of space separated integers, person ID's in the family.

Output Format:
--------------
Print the list of person IDs in ascending order.


Sample Input-1:
---------------
2 3 4 -1 5

Sample Output-1:
----------------
[5]

Sample Input-2:
---------------
11 99 88 77 -1 -1 66 55 -1 -1 -1 -1 -1 -1 44

Sample Output-2:
----------------
[44, 55, 66, 77]

*/

import java.util.*;

// TreeNode for reference

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

/*
*/

public class sp20 {
    public ArrayList<Integer> getPersonIDs(BinaryTreeNode root) {
        // Implement your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null || root.data == -1)
            return res;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp.left != null && temp.left.data != -1 && temp.right != null && temp.right.data != -1) {
                q.add(temp.left);
                q.add(temp.right);
            } else if (temp.left != null && temp.left.data != -1) {
                res.add(temp.left.data);
                q.add(temp.left);
            } else if (temp.right != null && temp.right.data != -1) {
                res.add(temp.right.data);
                q.add(temp.right);
            }
        }
        Collections.sort(res);
        return res;
    }
}
