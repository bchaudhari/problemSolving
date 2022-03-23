package com.bk;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class LongestSubstringLength {

	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int start = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if(hm.containsKey(c)) {
				start = Math.max(start, hm.get(c)+1);
			}
			hm.put(c, end);
			maxLength = Math.max(maxLength, end-start+1);
		}
		return maxLength;
	}

	// Slow
	public int lengthOfLongestSubstring1(String s) {
		int maxLength = 0;
		int start = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(int end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if(!set.contains(c)) {
				set.add(c);
			}
			else {
				while(set.contains(c)) {
					set.remove(s.charAt(start++));
				}		
			}
			maxLength = Math.max(maxLength, end-start+1);
			set.add(c);
		}
		return maxLength;
	}

	// Very slow
	public int lengthOfLongestSubstring2(String s) {
		int maxLength = 0;
		int counter = 0;
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!hm.containsKey(c)){
				hm.put(c, i);
				counter++;
				maxLength = Math.max(maxLength, counter);
			}
			else{
				maxLength = Math.max(maxLength, counter);
				i = hm.get(c);
				hm.clear();
				counter = 0;
			}
		}
		return maxLength;
	}
	public static void main(String[] args) {
		LongestSubstringLength sub = new LongestSubstringLength();
		System.out.println(sub.lengthOfLongestSubstring("dvdf"));

	}

}
