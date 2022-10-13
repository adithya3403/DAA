import java.util.*;

class ItemValue {
    int value, weight;

    public ItemValue(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class knapsack {
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