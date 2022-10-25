// sp07 PriorityNumber

/*

Subrahmanyam is working with numbers
He is given a list of numbers, his task is to find the priority number. 
The priority number is the number that occured more than 'list.length/2' times.

You may assume that the list is non-empty 
and the priority number always exist in the array.

Input Format:
-------------
line-1: an integer N, list size.
line-2: N space separated integers, numbers in the list[].

Output Format:
--------------
An integer, the priority number of the set.


Sample Input-1:
---------------
2
3 2 3

Sample Output-1:
----------------
3

Explanation:
------------
3 appeared 2 times(more then 3/2 times),where as 2 appeared 1 time.
So, 3 is the priority number.


Sample Input-2:
---------------
7
2 2 1 1 1 2 2

Sample Output-2:
----------------
2

Explanation:
------------
2 appeared 4 times(more then 7/2 times),where as 1 appeared 3 times.
So,2 is the priority number.

*/

import java.util.*;

public class sp07 {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int arr[], int low, int high) {
        int pi = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pi) {
                i++;
                if (i != j)
                    swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int priorityNum(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a[(int) a.length / 2];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(priorityNum(a));
        sc.close();
    }
}