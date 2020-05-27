package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/length-of-last-word/
 * 
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

Example:

Input: "Hello World"
Output: 5

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class LastWordLength {
	
	// faster approach
	public int lengthOfLastWord(String s) {
		int n = s.length() - 1;
		int length = 0;
		for(int i = n; i >= 0; i--) {
			if(s.charAt(i) != ' '){
				length++;
			}
			if(length > 0 && s.charAt(i) == ' ') {
				break;
			}
		}
		return length;
	}
	
	// slower approach
	public int lengthOfLastWord1(String s) {
		String[] tokens = s.split(" ");
		if(tokens.length == 0) 
			return 0;
		else 
			return tokens[tokens.length - 1].length();
	}

	public static void main(String[] args) {
		LastWordLength lastWordLength = new LastWordLength();
		
		String s1 = "Hello   ";
		
		System.out.println(lastWordLength.lengthOfLastWord(s1));

	}

}
