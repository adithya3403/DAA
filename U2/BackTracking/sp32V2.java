// sp32 Expressions-V2

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

public class sp32V2 {
	public String[] convert(String S) {
		List<String> res = new ArrayList<>();
		dfs(S, 0, new StringBuilder(), res);
		String[] out = new String[res.size()];
		for (int i = 0; i < res.size(); i++) {
			out[i] = res.get(i);
		}
		return out;
	}

	void dfs(String s, int index, StringBuilder sb, List<String> res) {
		if (index == s.length()) {
			if (sb.length() > 0) {
				res.add(sb.toString());
			}
			return;
		}
		char c = s.charAt(index);
		int position = sb.length();
		if (c == '[') {
			List<Character> charList = new ArrayList<>();
			int endIndex = index + 1;
			while (endIndex < s.length() && s.charAt(endIndex) != ']') {
				if (Character.isLetter(s.charAt(endIndex))) {
					charList.add(s.charAt(endIndex));
				}
				endIndex++;
			}
			Collections.sort(charList);
			for (char d : charList) {
				sb.append(d);
				dfs(s, endIndex + 1, sb, res);
				sb.setLength(position);
			}
		} else if (Character.isLetter(c)) {
			sb.append(s.charAt(index));
			dfs(s, index + 1, sb, res);
		}
	}
}