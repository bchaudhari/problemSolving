package educative.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * 
 * 
 * Example 1:
 * Input: "araaci", k= 2 
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * 
 * Example 2:
 * Input: "araaci", k= 1 
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * 
 * Example 3:
 * Input: "cbbebi", k= 3 
 * Output: 5
 * Explanation: The longest substring with no more than '2' distinct characters are "cbbeb" & "bbebi".
 * 
 * @author bk
 *
 */
public class LongestSubstringKDistinctChars {
	public static int longestSubString(String s, int k) {
		int longest = 0;
		int start = 0;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for(int end = 0; end < s.length(); end++) {
			Character c = s.charAt(end);
			hm.put(c, hm.getOrDefault(c, 0)+1);
			
			while(hm.size() > k) {
				c = s.charAt(start);
				hm.put(c, hm.get(c) - 1);
				if(hm.get(c) <= 0) {
					hm.remove(c);
				}
				start++;
			}
			
			longest = Math.max(longest, end-start+1);
		}
		
		return longest;	
	}

	public static void main(String[] args) {
		String s1 = "araaci";
		int k1 = 2;
		int out1 = longestSubString(s1, k1);
		System.out.println(out1);
		
		String s2 = "araaci";
		int k2 = 1;
		int out2 = longestSubString(s2, k2);
		System.out.println(out2);
		
		String s3 = "cbbebi";
		int k3 = 3;
		int out3 = longestSubString(s3, k3);
		System.out.println(out3);
	}

}
