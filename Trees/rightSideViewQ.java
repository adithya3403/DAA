import java.util.*;

/*
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

class rightSideViewQ {
    public List<Integer> rightSideView(BinaryTreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = q.poll();
                if (i == size - 1)
                    res.add(node.data);
                if (node.left != null && node.left.data != -1)
                    q.add(node.left);
                if (node.right != null && node.right.data != -1)
                    q.add(node.right);
            }
        }
        return res;
    }
}
