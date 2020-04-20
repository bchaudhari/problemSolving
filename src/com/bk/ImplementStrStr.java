package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/implement-strstr/
 * 
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
		if(needle == null || needle.isEmpty())
			return 0;
		else if(haystack == null || haystack.isEmpty())
			return -1;
		return haystack.indexOf(needle);
	}
	public static void main(String[] args) {
		String haystack1 = "hello";
		String needle1 = "ll";
		String haystack2 = "aaaaa";
		String needle2 = "baa";
		String haystack3 = "abc";
		String needle3 = "";
		String haystack4 = "";
		String needle4 = "a";
		
		ImplementStrStr implementStrStr = new ImplementStrStr();
		System.out.println("Expected 2 found --> " + implementStrStr.strStr(haystack1, needle1));
		System.out.println("Expected -1 found --> " + implementStrStr.strStr(haystack2, needle2));
		System.out.println("Expected 0 found --> " + implementStrStr.strStr(haystack3, needle3));
		System.out.println("Expected -1 found --> " + implementStrStr.strStr(haystack4, needle4));
	}
}
