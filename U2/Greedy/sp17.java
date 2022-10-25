// sp17 Knapsack

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
38.0

Explanation:
------------
Quantity = 2 + 4 + 6 + 3 = 15
Cost = 10 + 10 + 12 + 6 = 38


Sample Input-2:
---------------
4 21
18 6
20 3
14 5
18 9

Sample Output-2:
----------------
66.0

Explanation:
------------
Quantity = 6 + 3 + 5 + 4 = 18
Cost = 18 + 20 + 14 + 14 = 66

*/

import java.util.*;

class ItemValue {
    int value, weight;

    public ItemValue(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class sp17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int cap = sc.nextInt();
        ItemValue arr[] = new ItemValue[size];
        for (int i = 0; i < size; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[i] = new ItemValue(a, b);
        }
        System.out.println(getMaxValue(arr, cap));
        sc.close();
    }

    static double getMaxValue(ItemValue arr[], int cap) {
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                if (r1 < r2)
                    return 1;
                else if (r1 > r2)
                    return -1;
                return 0;
            }
        });
        double totalVal = 0d;
        for (ItemValue i : arr) {
            int curVal = (int) i.value;
            int curWt = (int) i.weight;
            if (cap - curWt >= 0) {
                cap = cap - curWt;
                totalVal += curVal;
                if (cap == 0)
                    break;
            } else {
                double fraction = ((double) cap / (double) curWt);
                totalVal += (curVal * fraction);
                cap = (int) (cap - (curWt * fraction));
                break;
            }
        }
        return totalVal;
    }
}