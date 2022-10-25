// sp25 SelfMirror

/*

Mr Rishil is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Anil to check whether BT is self mirror tree or not.
Can you help Anil to find and return "true" if the given BT is a self mirror tree,
otherwise return "false".

Implement the class Solution:
1. public boolean isSelfMirrorTree(BinaryTreeNode root): returns a boolean value.

NOTE:
- In the tree '-1', indicates empty(null).

Input Format:
-------------
A single line of space separated integers, values at the treenode

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 1 1 2 3 3 2

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 1 1 -1 3 -1 3

Sample Output-2:
----------------
false

// TreeNode Structure for Your Reference..

class BinaryTreeNode {
    public int data;
    public BinaryTreeNode left, right;

    public BinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

*/

public class sp25 {
    public boolean isSelfMirrorTree(BinaryTreeNode root) {
        // Implement Your Code here..
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    boolean isMirror(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return root1.data == root2.data &&
                isMirror(root1.left, root2.right) &&
                isMirror(root1.right, root2.left);
    }
}
