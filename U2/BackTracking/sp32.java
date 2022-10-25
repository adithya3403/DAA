// sp32 Expression
// grade: 75/100

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

class sp32 {
    public String[] convert(String S) {
        // Implement your logic here.
        List<String> res = new ArrayList<>();
        dfs(S, 0, new StringBuilder(), res);
        return res.toArray(new String[0]);
    }

    void dfs(String S, int i, StringBuilder sb, List<String> res) {
        if (i == S.length()) {
            res.add(sb.toString());
            return;
        }
        if (S.charAt(i) == '[') {
            int j = i + 1;
            while (S.charAt(j) != ']')
                j++;
            String[] strs = S.substring(i + 1, j).split(",");
            for (String str : strs) {
                sb.append(str);
                dfs(S, j + 1, sb, res);
                sb.setLength(sb.length() - str.length());
            }
        } else {
            sb.append(S.charAt(i));
            dfs(S, i + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }
}