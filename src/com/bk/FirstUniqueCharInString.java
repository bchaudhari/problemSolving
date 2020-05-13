package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/first-unique-character-in-a-string/
 * 

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class FirstUniqueCharInString {

	public int firstUniqChar(String s) {
		boolean[] charsPresent = new boolean['z' + 1];
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!charsPresent[c] && s.substring(i+1).indexOf(c) == -1)
				return i;
			else 
				charsPresent[c] = true;
		}
		return -1;
	}

	public static void main(String[] args) {
		String s1 = "leetcode";
		String s2 = "loveleetcode";
		String s3 = "aabbcc";
		String s4 = "cc";
		
		FirstUniqueCharInString firstUniqueCharInString = new FirstUniqueCharInString();
		System.out.println("Expected 0 found --> " + firstUniqueCharInString.firstUniqChar(s1));
		System.out.println("Expected 2 found --> " + firstUniqueCharInString.firstUniqChar(s2));
		System.out.println("Expected -1 found --> " + firstUniqueCharInString.firstUniqChar(s3));
		System.out.println("Expected -1 found --> " + firstUniqueCharInString.firstUniqChar(s4));

	}

}
