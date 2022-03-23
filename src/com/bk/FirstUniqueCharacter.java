package com.bk;

import java.util.HashMap;
import java.util.HashSet;

/***
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 * Given a string s, find the first non-repeating character in it and return its index. 
 * If it does not exist, return -1.
 * 
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * 
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * 
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class FirstUniqueCharacter {

	// Very slow
	public int firstUniqChar1(String s) {
		char[] chars = s.toCharArray();
		HashSet<Character> repeatChars = new HashSet();
		for(int i = 0; i < chars.length; i++) {
			char c = chars[i];
			int lastIndex = s.lastIndexOf(c);
			if(i == lastIndex && !repeatChars.contains(c))
				return i;
			else
				repeatChars.add(c);
		}
		return -1;
	}
	
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> hm = new HashMap();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!hm.containsKey(c)) 
				hm.put(c, 1);
			else 
				hm.put(c, hm.get(c)+1);
		}
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(hm.get(c) == 1) return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		FirstUniqueCharacter unique = new FirstUniqueCharacter();
		int out1 = unique.firstUniqChar("leetcode");
		System.out.println(out1);
		
		int out2 = unique.firstUniqChar("loveleetcode");
		System.out.println(out2);
		
		int out3 = unique.firstUniqChar("aabb");
		System.out.println(out3);
	}

}
