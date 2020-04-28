package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/count-and-say/
 * 
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 <= n <= 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: 4
Output: "1211"
Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class CountAndSay {
	public String countAndSay(int n) {
        String[] cs = new String[n+1];
        cs[1] = "1";
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
        	String prev = cs[i-1];
        	int counter = 1;        	
        	for(int j = 0; j < prev.length(); j++) {
        		if(j+1 < prev.length() && prev.charAt(j) == prev.charAt(j+1)) {
        			counter++;
        		} else {
        			sb.append(counter);
        			sb.append(prev.charAt(j));
        			counter = 1;
        		}
        		cs[i] = sb.toString();
        	}
        	sb.delete(0, sb.length());
        }
        return cs[n];
    }
	
	public static void main(String[] args) {
		CountAndSay countAndSay = new CountAndSay();
		System.out.println(countAndSay.countAndSay(30));
	}

}
