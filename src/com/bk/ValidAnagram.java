package com.bk;

import java.util.Arrays;
import java.util.HashMap;

/***
 * Leetcode - https://leetcode.com/problems/valid-anagram/
 * 
 Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ValidAnagram {

	public boolean isAnagram2(String s, String t) {
		if(s.length() != t.length()) return false;
		char[] sa = s.toLowerCase().toCharArray(); // Convert to lower case to handle mix case scenarios
		char[] ta = t.toLowerCase().toCharArray(); // Convert to lower case to handle mix case scenarios
		Arrays.sort(sa);
		Arrays.sort(ta);

		return new String(sa).equals(new String(ta));
	}

	// Without using Arrays.sort
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length())
			return false;

		HashMap<Character, Integer> charCounts = new HashMap<>();
		for(char c: s.toLowerCase().toCharArray()){
			charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
		}
		for(char c: t.toLowerCase().toCharArray()){
			if(charCounts.containsKey(c)){
				charCounts.put(c, charCounts.get(c) - 1);
				if(charCounts.get(c) < 1)
					charCounts.remove(c);
			}
			else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidAnagram anagram = new ValidAnagram();

		String s1 = "anagram";
		String t1 = "nagaram";

		String s2 = "DebitCard";
		String t2 = "Badcredit";

		String s3 = "abcd";
		String t3 = "abc";

		String s4 = "xyz";
		String t4 = "yxy";

		System.out.println("Expected true found --> " + anagram.isAnagram(s1, t1));
		System.out.println("Expected true found --> " + anagram.isAnagram(s2, t2));
		System.out.println("Expected false found --> " + anagram.isAnagram(s3, t3));
		System.out.println("Expected false found --> " + anagram.isAnagram(s4, t4));
	}
}
