package com.bk;

/***
 *  Self created 
 * 
 Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hELLO"
Example 2:

Input: "here"
Output: "HERE"
Example 3:

Input: "LOVELY"
Output: "lovely"

Example 3:

Input: "AbCd"
Output: "aBcD"

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */


public class SwapCase {
	// Simple method
	public String swapCase(String str) {
		char[] chars = str.toCharArray();
		int asciiDiff = 'a' - 'A';
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] >= 'A' && chars[i] <= 'Z') {
				chars[i] = (char) (chars[i] + asciiDiff);
			} else if (chars[i] >= 'a' && chars[i] <= 'z') {
				chars[i] = (char) (chars[i] - asciiDiff);
			}
		}
		return new String(chars);
	}
	
	public static void main(String[] args) {
		String s1 = "HeLLo";
		String s2 = "AbCd";
		String s3 = "XYZ";
		SwapCase swap = new SwapCase();
		System.out.println(swap.swapCase(s1));
		System.out.println(swap.swapCase(s2));
		System.out.println(swap.swapCase(s3));
	}
}
