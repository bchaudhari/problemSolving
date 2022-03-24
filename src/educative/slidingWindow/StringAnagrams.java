package educative.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * Every anagram is a permutation of a string. As we know, when we are not allowed to repeat characters while finding permutations of a string, we get N ! permutations (or anagrams) of a string having N characters. For example, here are the six anagrams of the string “abc”:\
 * 1. abc 2. acb 3. bac 4. bca 5. cab 6. cba
 * 
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 * 
 * Example 1:
 * 
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 * 
 * Example 2:
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 * 
 * 
 * @author bk
 *
 */
public class StringAnagrams {
	
	public ArrayList<Integer> findAnagrams(String s, String pattern) {
		ArrayList<Integer> resultList = new ArrayList<>();
		
		HashMap<Character, Integer> patternCharCounts = new HashMap<>();
		for(char c: pattern.toCharArray()) {
			patternCharCounts.put(c, patternCharCounts.getOrDefault(c, 0)+1);
		}
		int start = 0;
		int matchCount = 0;
		for(int end = 0; end < s.length(); end++) {
			char right = s.charAt(end);
			if(patternCharCounts.containsKey(right)) {
				patternCharCounts.put(right, patternCharCounts.get(right)-1);
				
				if(patternCharCounts.get(right) == 0) {
					matchCount++;
				}
			}
			
			if(matchCount == patternCharCounts.size()) {
				resultList.add(start);
			}
			
			if(end >= pattern.length() - 1) {
				char left = s.charAt(start++);
				if(patternCharCounts.containsKey(left)) {
					if(patternCharCounts.get(left) == 0) {
						matchCount--;
					}
					patternCharCounts.put(left, patternCharCounts.get(left) + 1);
				}
			}
			
		}
		
		return resultList;
	}

	public static void main(String[] args) {
		StringAnagrams anagrams = new StringAnagrams();
		System.out.println(anagrams.findAnagrams("ppqp", "pq"));
		System.out.println(anagrams.findAnagrams("abbcabc", "abc"));

	}

}
