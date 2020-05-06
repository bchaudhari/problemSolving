package com.bk;

import java.util.Hashtable;
import java.util.Set;

/***
 * Leetcode - https://leetcode.com/problems/longest-palindrome/
 * 
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class LongestPalindromeCount {
	
	// Faster solution
	public int longestPalindrome(String s) {
        int result = 0;
        boolean foundOdd = false;
        int[] charCounter = new int[128];
        
        
        for(char c: s.toCharArray()){
            charCounter[c]++;
        }
        
        for(int value: charCounter){
        	result = result + (value/2);
        	if(!foundOdd && (value % 2 == 1)) {
        		foundOdd = true;
        	}	
        }
        
        return (result * 2) + (foundOdd? 1: 0);
    }
	
	// Very slow
	public int longestPalindrome1(String s) {
        int result = 0;
        boolean center = true;
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        // Read input string and put count for each char in hashtable
        for(char c: s.toCharArray()){
            if(ht.containsKey(c)){
               ht.put(c, ht.get(c) + 1);
            } else {
                ht.put(c, 1);
            }
        }
        
        // Process Hashtable data
        Set<Character> keys = ht.keySet();
        if (keys.size() == 1) 
        	return ht.get(keys.iterator().next());
        for(Character key: keys){
        	int value = ht.get(key);
            if(center && value == 1){
                result++;
                center = false;
            } else if(value > 1) {
            	if(value % 2 == 0) {
            		result = result + value;
            	} else if(!center) {
            		result = result + value -1;
            	} else {
            		result = result + value;
            		center = false;
            	}
            }
        }
        return result;
    }
	public static void main(String[] args) {
		LongestPalindromeCount count = new LongestPalindromeCount();
		
		String s1 = "abccccdd";
		System.out.println("Expected 7 found --> " + count.longestPalindrome(s1));
		
		String s2 = "abccccddA";
		System.out.println("Expected 7 found --> " + count.longestPalindrome(s2));
		
		String s3 = "abccccddAc";
		System.out.println("Expected 7 found --> " + count.longestPalindrome(s3));
		
		String s4 = "abc";
		System.out.println("Expected 1 found --> " + count.longestPalindrome(s4));
		
		String s5 = "abcabc";
		System.out.println("Expected 6 found --> " + count.longestPalindrome(s5));
		
		String s6 = "Aa";
		System.out.println("Expected 1 found --> " + count.longestPalindrome(s6));
		
		String s7 = "ccc";
		System.out.println("Expected 3 found --> " + count.longestPalindrome(s7));
		
		String s8 = "ababababa";
		System.out.println("Expected 9 found --> " + count.longestPalindrome(s8));
	}

}
