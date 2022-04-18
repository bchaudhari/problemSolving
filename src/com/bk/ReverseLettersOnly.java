package com.bk;

/**
 * https://leetcode.com/problems/reverse-only-letters/
 * https://algodaily.com/challenge_slides/reverse-only-alphabetical
 * 
 * Given a string s, reverse the string according to the following rules:
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 * 
 * Example 1:
 * Input: s = "ab-cd"
 * Output: "dc-ba"
 * 
 *
 * @author bk
 *
 */
public class ReverseLettersOnly {

	public String reverseOnlyLetters(String s) {
		char[] chars = s.toCharArray();
		int left = 0;
		int right = chars.length - 1;

		while(left < right){
			if(!Character.isAlphabetic(chars[left]))
				left++;
			if(!Character.isAlphabetic(chars[right]))
				right--;
			if(Character.isAlphabetic(chars[left]) && Character.isAlphabetic(chars[right])){
				// swap
				char temp = chars[left];
				chars[left++] = chars[right];
				chars[right--] = temp;    
			}     
		}
		return new String(chars);
	}

	public static void main(String[] args) {
		ReverseLettersOnly reverse = new ReverseLettersOnly();
		System.out.println(reverse.reverseOnlyLetters("ab-cd")); // Expected "dc-ba"
		System.out.println(reverse.reverseOnlyLetters("a-bC-dEf-ghIj")); // Expected "j-Ih-gfE-dCba"
		System.out.println(reverse.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // Expected "Qedo1ct-eeLg=ntse-T!"

	}

}
