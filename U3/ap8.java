// ap8 digital_Clock

/*

Bindu is passionated about clocks.
She found a digital clock, which has 2 rows of led lights,
Top row has 4-leds OOOO indicates hours (0-11).
Bottom row has 6-leds OOOOOO indicates minutes(0-59).
Where O -> led is OFF and * -> led is ON.

For Example: 
If the clock showing the led lights are as follows:
	OO*O indiactes a binary number, 0010 -> 2 hrs
	OO*O** indiactes a binary number, 001011 -> 11 minutes.
So, Time is 2:11

Now, you are given an integer N, number of led lights that are ON.
Your task is to find, all the  possible times in ascending order.

Format of time should be as follows:
	- Hours should not have leading 0's.
	- Minutes should be represented with 2 digits.

Suppose Current time is 1 hous 1 minute
	- Valid time is 1:01
	- Invalid time is as follows:- 01:1, 01:01, 1:1

Input Format:
-------------
An integer N, number of led lights ON.

Output Format:
--------------
Return the list of times in which are valid.


Sample Input:
---------------
1

Sample Output:
----------------
[0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]

*/

import java.util.*;

class ap8 {
    public List<String> readDigitalClock(int num) {
        // Implement your code here.
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (countOnes(h) + countOnes(m) == num) {
                    res.add(String.format("%d:%02d", h, m));
                } else {
                    continue;
                }
            }
        }
        return res;
    }

    static int countOnes(int n) {
        String bin = Integer.toBinaryString(n);
        int count = 0;
        for (int i : bin.toCharArray()) {
            if (i == '1')
                count++;
        }
        return count;
    }
}