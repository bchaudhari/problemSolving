package com.bk;

import javax.print.attribute.standard.Compression;

/***
 * Leetcode - https://leetcode.com/problems/string-compression/
 * 
 Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:

Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


Example 2:

Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.


Example 3:

Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.


Note:

All characters have an ASCII value in [35, 126].
1 <= len(chars) <= 1000.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class StringCompression {
	public int compress(char[] chars) {
		int counter = 1;
		int index = 0;
		int n = chars.length;
		for(int i = 0; i <= n - 2; i++) {
			if(chars[i] == chars[i+1]) {
				counter++;
			} else {
				if (counter >= 2) {
					chars[index++] = chars[i];
					char[] counterStr = Integer.toString(counter).toCharArray();
					for(char c: counterStr) {
						chars[index++] = c;
					}
					counter = 1;
				} else {
					chars[index++] = chars[i];
					counter = 1;
				}
			}
		}
		chars[index++] = chars[n-1];
		if(counter >=2) {
			char[] counterStr = Integer.toString(counter).toCharArray();
			for(char c: counterStr) {
				chars[index++] = c;
			}	
		}
		return index;
	}
	public static void main(String[] args) {
		char[] input1 = {'a','a','b','b','c','c','c'};
		char[] input2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b','c','d'};
		char[] input3 = {'a','a','a','b','b','a','a'};
		char[] input4 = {'a', 'b', 'c', 'd'};
		char[] input5 = {'a', 'a', 'b','b','c', 'c', 'a', 'a'};
		char[] input6 = {'a','a','a','a','a','a','a'};
		StringCompression compression = new StringCompression();
		System.out.println("Expected 6 found --> " + compression.compress(input1));
		System.out.println("Expected 6 found --> " + compression.compress(input2));
		System.out.println("Expected 6 found --> " + compression.compress(input3));
		System.out.println("Expected 4 found --> " + compression.compress(input4));
		System.out.println("Expected 8 found --> " + compression.compress(input5));
		System.out.println("Expected 2 found --> " + compression.compress(input6));
	}

}
