package com.bk;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode - https://leetcode.com/problems/buddy-strings/
 * 
  Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.



Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false


Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class BuddyStrings {
	
	// Runtime 1 ms
	// Faster than 98.63%
	// some improvement made in using variables compared to other solution below.
	public boolean buddyStrings(String A, String B) {
		if(A.length() != B.length()){
			return false;
		}

		if(A.equals(B)) {
			// find if string contains at least 1 duplicate char
			// by swaping these 2 chars won't make difference
			Set<Character> dup = new HashSet<Character> ();
			for(int i = 0; i < A.length(); i++){
				if(dup.contains(A.charAt(i))){
					return true;
				}
				dup.add(A.charAt(i));
			}
		} else {
			int diff1 = -1;
			int diff2 = -1;
			for(int i = 0; i < A.length(); i++){
				if(A.charAt(i) != B.charAt(i)){
					if(diff1 == -1) {
						diff1 = i;
					} else if (diff2 == -1) {
						diff2 = i;
					} else {
						// found more than 2 differences
						return false;
					}
					
				}
			}
			
			return (diff2 != -1 &&A.charAt(diff1) == B.charAt(diff2) && 
					A.charAt(diff2) == B.charAt(diff1));
		}
		return false;
	}

	// Runtime 1ms
	// Faster than 98.63%
	public boolean buddyStrings1(String A, String B) {
		if(A.length() != B.length()){
			return false;
		}

		if(A.equals(B)) {
			// find if string contains at least 1 duplicate char
			// by swaping these 2 chars won't make difference
			Set<Character> dup = new HashSet<Character> ();
			for(int i = 0; i < A.length(); i++){
				if(dup.contains(A.charAt(i))){
					return true;
				}
				dup.add(A.charAt(i));
			}
		} else {
			int diffCount = 0;
			int[] diffIndexes = new int[3]; // 1 extra to handle index out of bound

			for(int i = 0; i < A.length(); i++){
				if(diffCount > 2)
					return false;
				if(A.charAt(i) != B.charAt(i)){
					diffIndexes[diffCount++] = i;
				}
			}

			if(diffCount != 2)
				return false;

			// At this point we found exact 2 diffs 
			return (A.charAt(diffIndexes[0]) == B.charAt(diffIndexes[1]) && 
					A.charAt(diffIndexes[1]) == B.charAt(diffIndexes[0]));
		}
		return false;
	}
	public static void main(String[] args) {
		BuddyStrings bs = new BuddyStrings();
		System.out.println("Expected true found --> " + bs.buddyStrings("aa", "aa"));
		System.out.println("Expected true found --> " + bs.buddyStrings("aaa", "aaa"));
		System.out.println("Expected true found --> " + bs.buddyStrings("ab", "ba"));
		System.out.println("Expected false found --> " + bs.buddyStrings("ab", "ab"));
		System.out.println("Expected true found --> " + bs.buddyStrings("aaaaaaabc", "aaaaaaacb"));
		System.out.println("Expected false found --> " + bs.buddyStrings("", "aa"));
	}

}
