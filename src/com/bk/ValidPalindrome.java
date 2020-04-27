package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/valid-palindrome/
 * 
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ValidPalindrome {
	// Fastest
	public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() -1;
		while(j > i) {
			while(j > i && !isAlphanumeric(s.charAt(i)))
				i++;
			while(j > i && !isAlphanumeric(s.charAt(j)))
				j--;
			
			if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
				return false;
			}
		}
		return true;
	}
	public boolean isAlphanumeric(char c) {
		return (Character.isAlphabetic(c) || Character.isDigit(c));
	}
	
	public boolean isPalindrome3(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		if(s.isEmpty())
			return true;
		int i = 0;
		int j = s.length() -1;
		while(j >= i) {
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public boolean isPalindrome2(String s) {
		String filteredInput = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		if(filteredInput.isEmpty())
			return true;
		int len = filteredInput.length();
		String result = "";
		for(int i = len-1; i >= 0; i--) {
			result = result + filteredInput.charAt(i);
		}
		return filteredInput.equals(result);
	}
	public boolean isPalindrome1(String s) {
		String filteredInput = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		if(filteredInput.isEmpty())
			return true;
		StringBuffer sb = new StringBuffer(filteredInput);
		sb.reverse();
		return filteredInput.equals(sb.toString());
	}
	public static void main(String[] args) {
		String s1 = "A man, a plan, a canal: Panama";
		String s2 = "race a car";
		String s3 = "";
		String s4 = "0P";
		String s5 = " ";

		ValidPalindrome palindrome = new ValidPalindrome();
		System.out.println("Expected true found --> " + palindrome.isPalindrome(s1));
		System.out.println("Expected false found --> " + palindrome.isPalindrome(s2));
		System.out.println("Expected true found --> " + palindrome.isPalindrome(s3));
		System.out.println("Expected false found --> " + palindrome.isPalindrome(s4));
		System.out.println("Expected true found --> " + palindrome.isPalindrome(s5));
	}

}
