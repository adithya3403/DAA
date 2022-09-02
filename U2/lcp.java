import java.util.*;

public class lcp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        System.out.println(longestCommonPrefix(words));
        sc.close();
    }

    public static String longestCommonPrefix(String[] words) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i + 1);
                map.put(prefix, map.getOrDefault(prefix, 0) + 1);
            }
        }
        String ans = "";
        for (String key : map.keySet())
            if (map.get(key) == words.length)
                ans = key;
        return ans;
    }
}