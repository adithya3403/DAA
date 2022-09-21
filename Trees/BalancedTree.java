/*

Mr Rishil is interested to work on Data Structures.
He has constructed a BinaryTree-BT.

He asked his friend Anil to check whether BT is a balanced BT or not.
A balanced BT is defined as follows:
- the binary tree in which the left and right subtrees of every node 
differ in height by no more than 1.

Can you help Anil to find and return "true" if the given BT is a balanced tree,
otherwise return "false".

Implement the class Solution:
1. public boolean isBalanced(BinaryTreeNode root): returns a boolean value.

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
1 2 3 4 5 -1 -1 6 7

Sample Output-2:
----------------
false

*/

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
    public boolean isBalanced(BinaryTreeNode root) {
        // Implement Your Code here..
        if (root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) <= 1) {
            if (isBalanced(root.left) && isBalanced(root.right)) {
                return true;
            }
        }
        return false;
    }

    public int height(BinaryTreeNode root) {
        if (root == null || root.data == -1)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
