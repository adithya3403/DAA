// sp37 Knapsack
// Grade: 83.33 / 100 (Test Case 4 failed)

/*

Mr. Dharma went to D-mart, and picked a basket with a capacity C.
There are N products in Dharma's wishlist.
You will be given desired cost and quantity of each Product.
Out of the wishlist Mr Dharma has, he wants to purchase the products in the following way:
	- The sum of quantities taken into the basket is less than or equal to C.
	- The sum of cost of the products in the basket is maximum among all 
	the possible combinations of products.

Your task is to help, Mr. Dharma to purachase the products with maximum cost, 
with the given basket capacity. 

Input Format:
-------------
Line-1: Two space separated integers, N and C.
Next N lines: Two space separated integers, Ci and Qi.
			cost and quantity of i-th product.

Output Format:
--------------
Print an integer, Maximum cost to pay to D-Mart.


Sample Input-1:
---------------
4 15
10 2
10 4
12 6
18 9

Sample Output-1:
----------------
38

Explanation:
------------
Quantity = 2 + 4 + 9 = 15
Cost = 10 + 10 + 18 = 38


Sample Input-2:
---------------
4 21
18 6
20 3
14 5
18 9

Sample Output-2:
----------------
56

Explanation:
------------
Quantity = 6 + 3 + 9 = 18
Cost = 18 + 20 + 18 = 56

*/

import java.util.*;

class Item {
    float weight;
    int value;
    int idx;

    public Item() {
    }

    public Item(int value, float weight, int idx) {
        this.value = value;
        this.weight = weight;
        this.idx = idx;
    }
}

class Node {
    float ub;
    float lb;
    int level;
    boolean flag;
    float tv;
    float tw;

    public Node() {
    }

    public Node(Node cpy) {
        this.tv = cpy.tv;
        this.tw = cpy.tw;
        this.ub = cpy.ub;
        this.lb = cpy.lb;
        this.level = cpy.level;
        this.flag = cpy.flag;
    }
}

class sp37 {
    private int size;
    private float capacity;

    sp37(int size, int capacity) {
        this.size = size;
        this.capacity = capacity;
    }

    public void solve(Item arr[]) {
        // implement your code here.
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return (int) (o2.value / o2.weight - o1.value / o1.weight);
            }
        });
        Node root = new Node();
        root.level = 0;
        root.tv = 0;
        root.tw = 0;
        root.flag = false;
        root.lb = 0;
        root.ub = 0;
        for (int i = 0; i < size; i++) {
            root.ub += arr[i].value;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int) (o2.ub - o1.ub);
            }
        });
        pq.add(root);
        int max = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.level == size)
                continue;
            if (curr.ub < max)
                break;
            Node left = new Node(curr);
            left.level++;
            left.flag = false;
            left.tw += arr[left.level - 1].weight;
            left.tv += arr[left.level - 1].value;
            left.lb = left.tv;
            if (left.tw <= capacity) {
                if (left.tv > max)
                    max = (int) left.tv;
                left.ub = bound(left, arr);
                if (left.ub > max)
                    pq.add(left);
            }
            Node right = new Node(curr);
            right.level++;
            right.flag = true;
            right.lb = right.tv;
            right.ub = bound(right, arr);
            if (right.ub > max)
                pq.add(right);
        }
        System.out.println(max);
    }

    float bound(Node node, Item arr[]) {
        float res = node.tv;
        float cap = capacity - node.tw;
        int i = node.level;
        while (i < size && arr[i].weight <= cap) {
            cap -= arr[i].weight;
            res += arr[i].value;
            i++;
        }
        if (i < size)
            res += arr[i].value * cap / arr[i].weight;
        return res;
    }
}