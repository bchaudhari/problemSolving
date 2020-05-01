package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/to-lower-case/
 * 
 Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */

/***
 * Bit manipulation explanation
 
ASCII value of A is 65, binary form is 1000001
ASCII value of a is 97, binary form is 1100001

The difference between these two is 32.

So perform OR operation between the give character and 32.

Case 1 : If the character us upper case A

A | 32

1000001
0100000

1100001 = 97 = a

Case 2 : If the given character is lower case a

a | 32

1100001
0100000

1100001 = 97 = a
 */
public class ToLowerCase {
	
	// Bit manipulation method
	public String toLowerCase1(String str) {
		char[] chars = str.toCharArray();
		int asciiDiff = 'a' - 'A';
		for(int i = 0; i < chars.length; i++) {
			chars[i] = chars[i] |= asciiDiff;
		}
		return new String(chars);
	}
	
	// Simple method
	public String toLowerCase(String str) {
		char[] chars = str.toCharArray();
		int asciiDiff = 'a' - 'A';
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] >= 'A' && chars[i] <= 'Z') {
				chars[i] = (char) (chars[i] + asciiDiff);
			}
		}
		return new String(chars);
	}
	
	public static void main(String[] args) {
		String s1 = "HeLLo";
		String s2 = "abcd";
		String s3 = "XYZ";
		ToLowerCase lower = new ToLowerCase();
		System.out.println(lower.toLowerCase(s1));
		System.out.println(lower.toLowerCase(s2));
		System.out.println(lower.toLowerCase(s3));
	}

}
