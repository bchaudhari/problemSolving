package com.bk;

import java.util.Arrays;

/**
 * Re-arrange characters of a word/String. Assume that input contains only alphabets
 * 
 * Example:
 * 
 * input: axbyczh
 * output: abchxyz
 * 
 * @author bk
 *
 */
public class ReorderCharsOfWord {

	public String alphabeticalOrder(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}
	public static void main(String[] args) {
		ReorderCharsOfWord reorder = new ReorderCharsOfWord();
		System.out.println(reorder.alphabeticalOrder("bhavesh"));
		System.out.println(reorder.alphabeticalOrder("abcdefg"));
		System.out.println(reorder.alphabeticalOrder("axbyczh"));
	}

}
