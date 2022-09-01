// QuickSort
// Sample Input-1:
// 2
// 3 2 3
// Sample Output-1: 3
// Sample Input-2:
// 7
// 2 2 1 1 1 2 2
// Sample Output-2: 2

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