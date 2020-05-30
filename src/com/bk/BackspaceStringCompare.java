package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/backspace-string-compare/
 * 
 Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		// Read both the strings in reverse order
		// compare char by char
		// For every # increment skip counter and move to next char. 
		// Once non-# char is found, move pointer to left by position = skip counter.
		// if no # is found and skip counter is 0 then that char is eligible for comparison.
		
		// Index pointer for String S
		int sp = S.length() - 1;

		// Index pointer for String T
		int tp = T.length() - 1;

		int sSkip = 0;
		int tSkip = 0;

		while(sp >= 0 || tp >= 0) {
			while(sp >= 0) {
				if(S.charAt(sp) == '#') {
					sSkip++;
					sp--;
				}
				else if(sSkip > 0) {
					sp--;
					sSkip--;
				} else {
					break;
				}
			}

			while(tp >= 0) {
				if(T.charAt(tp) == '#') {
					tSkip++;
					tp--;
				}
				else if(tSkip > 0) {
					tp--;
					tSkip--;
				}
				else {
					break;
				}
			}

			if(sp >= 0 && tp >= 0 && S.charAt(sp) != T.charAt(tp)) {
				return false;
			}
			if((sp >= 0) != (tp >= 0)) {
				return false;
			}
			sp--;
			tp--;
		}
		return true;
	}
	public static void main(String[] args) {
		BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();		

		System.out.println(backspaceStringCompare.backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceStringCompare.backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceStringCompare.backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceStringCompare.backspaceCompare("a##c", "b"));

	}

}
