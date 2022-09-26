// grade: 25/100

/*

Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert given expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]

*/

import java.util.*;

class Expressions {
    public String[] convert(String S) {
        // Implement your logic here.
        List<String> res = new ArrayList<>();
        int n = S.length(), i = 0;
        while (i < n) {
            if (S.charAt(i) == '[') {
                int j = i + 1;
                while (j < n && S.charAt(j) != ']') {
                    j++;
                }
                String[] strs = S.substring(i + 1, j).split(",");
                if (res.size() == 0) {
                    for (String str : strs) {
                        res.add(str);
                    }
                } else {
                    List<String> tmp = new ArrayList<>();
                    for (String str : strs) {
                        for (String s : res) {
                            tmp.add(s + str);
                        }
                    }
                    res = tmp;
                }
                i = j + 1;
            } else {
                if (res.size() == 0) {
                    res.add(S.substring(i, i + 1));
                } else {
                    for (int j = 0; j < res.size(); j++) {
                        res.set(j, res.get(j) + S.substring(i, i + 1));
                    }
                }
                i++;
            }
        }
        String[] ans = new String[res.size()];
        for (int j = 0; j < res.size(); j++) {
            ans[j] = res.get(j);
        }
        return ans;
    }
}