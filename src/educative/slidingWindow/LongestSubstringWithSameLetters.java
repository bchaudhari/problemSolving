package educative.slidingWindow;

import java.util.HashMap;

/**
 * Given a string with lowercase letters only, if you are allowed to replace 
 * no more than k letters with any letter, find the length of the longest 
 * substring having the same letters after replacement. (HARD)
 * 
 *  Example 1:
 *  Input: String="aabccbb", k=2
 *  Output: 5
 *  Explanation: Replace the two 'c' with 'b' to have the longest 
 *  repeating substring "bbbbb".
 *  
 *  Example 2:
 *  Input: String="abbcb", k=1
 *  Output: 4
 *  Explanation: Replace the 'c' with 'b' to have the longest repeating substring "bbbb".
 *  
 *  Example 3:
 *  Input: String="abccde", k=1
 *  Output: 3
 *  Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 *  
 *  @author bk
 */

public class LongestSubstringWithSameLetters {

	public int findLongestSubString(String s, int k) {
		int start = 0;
		int maxLen = 0;
		// count of maximum repeating letter in any window
		int maxCount = 0;
		HashMap<Character, Integer> letterFrequency = new HashMap<>();

		for(int end = 0; end < s.length(); end++) {
			char right = s.charAt(end);
			letterFrequency.put(right, letterFrequency.getOrDefault(right, 0) + 1);
			maxCount = Math.max(maxCount, letterFrequency.get(right));

			while(end - start + 1 - maxCount > k) {
				char left = s.charAt(start);
				letterFrequency.put(left, letterFrequency.get(left) - 1);
				if(letterFrequency.get(left) == 0) {
					letterFrequency.remove(left);
				}
				start++;
			}
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;

	}
	public static void main(String[] args) {
		LongestSubstringWithSameLetters ls = new LongestSubstringWithSameLetters();
		// Example:1
		String s1 = "aabccbb";
		int k1 = 2;
		int out1 = ls.findLongestSubString(s1, k1);
		System.out.println(out1);

		// Example:2
		String s2 = "abbcb";
		int k2 = 1;
		int out2 = ls.findLongestSubString(s2, k2);
		System.out.println(out2);

		// Example:3
		String s3 = "abccde";
		int k3 = 1;
		int out3 = ls.findLongestSubString(s3, k3);
		System.out.println(out3);

	}

}
