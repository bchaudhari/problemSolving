package com.bk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Re-arrange only alphabets of given string. String can have alphanumeric character. 
 * You can assume there is no space or special characters in given string.
 * 
 * Example:
 * 
 * input: xyz123abcd
 * output: abc123dxyz
 * 
 * @author bk
 *
 */
public class ReorderAlphabetsOfAlphanumericString {

	public String alphabeticalOrder(String str) {
		char[] charArray = str.toCharArray();
		List<Character> alphabetsOnlyList = new ArrayList<>();
		for(char c: charArray) {
			if(Character.isAlphabetic(c)) {
				alphabetsOnlyList.add(c);
			}
		}
		
		Character[] alphabets = alphabetsOnlyList.toArray(new Character[alphabetsOnlyList.size()]);
		Arrays.sort(alphabets);
		int counter = 0;
		for(int i = 0; i < charArray.length; i++) {
			if(Character.isAlphabetic(charArray[i])) {
				charArray[i] = alphabets[counter++];
			}
		}
		
		return new String(charArray);
	}
	public static void main(String[] args) {
		ReorderAlphabetsOfAlphanumericString reorder = new ReorderAlphabetsOfAlphanumericString();
		System.out.println(reorder.alphabeticalOrder("xyz123abcd")); // Expected abc123dxyz
	}

}
