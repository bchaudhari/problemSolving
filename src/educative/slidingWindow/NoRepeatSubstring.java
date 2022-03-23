package educative.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring, which has no 
 * repeating characters.
 * 
 * Example 1:
 * Input: String="aabccbb" 
 * Output: 3
 * Explanation: The longest substring without any repeating characters is "abc".
 * 
 * Example 2:
 * Input: String="abbbb" 
 * Output: 2
 * Explanation: The longest substring without any repeating characters is "ab".
 * 
 * Example 3:
 * Input: String="abccde" 
 * Output: 3
 * Explanation: Longest substrings without any repeating characters are "abc" & "cde".
 * 
 * Example 4:
 * Input: String="cabcde" 
 * Output: 5
 * Explanation: Longest substrings without any repeating characters is "abcde".
 * 
 * @author bk
 *
 */
public class NoRepeatSubstring {
	
	public static int longestNonRepeatingSubstring(String s) {
		int longest = 0;
		int start = 0;
		Set<Character> uniqueChars = new HashSet<Character> ();
		for(int end = 0; end < s.length(); end++) {
			Character c = s.charAt(end);
			if(!uniqueChars.contains(c)) {
				uniqueChars.add(c);
			}
			else {
				while(s.charAt(start) != c) {
					uniqueChars.remove(s.charAt(start));
					start++;
				}
				start++;
			}
			longest = Math.max(longest, end - start + 1);
		}
		return longest;
	}
	
	public static void main(String[] args) {
		String s1 = "aabccbb";
		int out1 = longestNonRepeatingSubstring(s1);
		System.out.println(out1);
		
		String s2 = "abbbb";
		int out2 = longestNonRepeatingSubstring(s2);
		System.out.println(out2);
		
		String s3 = "abccde";
		int out3 = longestNonRepeatingSubstring(s3);
		System.out.println(out3);
		
		String s4 = "cabcde";
		int out4 = longestNonRepeatingSubstring(s4);
		System.out.println(out4);
	}

}
