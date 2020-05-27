package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/reverse-vowels-of-a-string/
 * 
 Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] strChars = s.toCharArray();
        while(i < j){
            if(!isVowel(strChars[i])){
                i++;
            } 
            if(!isVowel(strChars[j])){
                j--;
            }
            if(isVowel(strChars[i]) && isVowel(strChars[j])){
                char temp = strChars[i];
                strChars[i] = strChars[j];
                strChars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(strChars);
    }
    public boolean isVowel(char c){
        char c1 = Character.toLowerCase(c);
        return (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u' );
    }
	public static void main(String[] args) {
		ReverseVowelsOfString reverse = new ReverseVowelsOfString();
		System.out.println(reverse.reverseVowels("leetcode"));
		System.out.println(reverse.reverseVowels("aaaaeee"));
		

	}

}
