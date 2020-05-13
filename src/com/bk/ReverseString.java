/**
 * 
 */
package com.bk;

import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/reverse-string/
 * 
 Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.



Example 1:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ReverseString {

	public void reverseString(char[] s) {
		char temp;
		int left = 0;
		int right = s.length - 1;
		
		while(left < right) {
			temp = s[right];
			s[right] = s[left];
			s[left] = temp;
			right--;
			left++;
		}	
	}
	public static void main(String[] args) {
		char[] s1 = {'h','e','l','l','o'};
		ReverseString revString = new ReverseString();
		revString.reverseString(s1);
		Printer.printArray(s1);
		
		char[] s2 = {'h','a','n','n','a','h'};
		revString.reverseString(s2);
		System.out.println("\n");
		Printer.printArray(s2);
	}
}
