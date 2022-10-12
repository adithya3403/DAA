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

class Solution {
    private int size;
    private float capacity;

    Solution(int size, int capacity) {
        this.size = size;
        this.capacity = capacity;
    }

    public void solve(Item arr[]) {
        // implement your code here.
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                float r1 = (float) o1.value / o1.weight;
                float r2 = (float) o2.value / o2.weight;
                if (r1 < r2)
                    return 1;
                else if (r1 > r2)
                    return -1;
                return 0;
            }
        });
        float totalVal = 0f;
        for (Item i : arr) {
            int curVal = (int) i.value;
            float curWt = (float) i.weight;
            if (capacity - curWt >= 0) {
                capacity = capacity - curWt;
                totalVal += curVal;
                if (capacity == 0)
                    break;
            } else {
                float fraction = ((float) capacity / (float) curWt);
                totalVal += (curVal * fraction);
                capacity = (float) (capacity - (curWt * fraction));
                break;
            }
        }
        System.out.println((int) totalVal);
    }
}
