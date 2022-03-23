package educative.slidingWindow;

import java.util.HashMap;

/**
 * 
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * Permutation is defined as the re-arranging of the characters of the string. 
 * For example, “abc” has the following six permutations:
 * 1. abc 2. acb 3. bac 4. bca 5. cab 6. cba
 * If a string has ‘n’ distinct characters, it will have n! permutations.
 * 
 * Example 1:
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 * 
 * Example 2:
 * Input: String="odicf", Pattern="dc"
 * Output: false
 * Explanation: No permutation of the pattern is present in the given string as a substring.
 * 
 * Example 3:
 * Input: String="bcdxabcdy", Pattern="bcdyabcdx"
 * Output: true
 * Explanation: Both the string and the pattern are a permutation of each other.
 * 
 * Example 4:
 * Input: String="aaacb", Pattern="abc"
 * Output: true
 * Explanation: The string contains "acb" which is a permutation of the given pattern.
 * 
 * @author bk
 *
 */
public class PermutationInString {

	public boolean containsPermutation(String s, String pattern) {
		HashMap<Character, Integer> patternCharCountMap = new HashMap<>();
		for(char c: pattern.toCharArray()) {
			patternCharCountMap.put(c, patternCharCountMap.getOrDefault(c, 0)+1);
		}

		int matchCount = 0;
		int start = 0;
		for(int end = 0; end < s.length(); end++) {
			char right = s.charAt(end);
			if(patternCharCountMap.containsKey(right)) {
				patternCharCountMap.put(right, patternCharCountMap.get(right) - 1);
				if(patternCharCountMap.get(right) == 0) {
					matchCount++;
				}
			}
			if(matchCount == patternCharCountMap.size()) {
				return true;
			}
			if(end >= pattern.length() - 1) {
				char left = s.charAt(start);
				start++;
				if(patternCharCountMap.containsKey(left)) {
					if(patternCharCountMap.get(left) == 0) {
						matchCount--;
					}
					patternCharCountMap.put(left, patternCharCountMap.get(left) + 1);
				}	
			}
		}
		return false;
	}

	public static void main(String[] args) {
		PermutationInString permutationInString = new PermutationInString();
		String s1 = "oidbcaf";
		String p1 = "abc";
		System.out.println(permutationInString.containsPermutation(s1, p1));

		String s2 = "odicf";
		String p2 = "dc";
		System.out.println(permutationInString.containsPermutation(s2, p2));

		String s3 = "bcdxabcdy";
		String p3 = "bcdyabcdx";
		System.out.println(permutationInString.containsPermutation(s3, p3));

		String s4 = "aaacb";
		String p4 = "abc";
		System.out.println(permutationInString.containsPermutation(s4, p4));

		String s5 = "dcda";
		String p5 = "adc";
		System.out.println(permutationInString.containsPermutation(s5, p5));
	}

}
