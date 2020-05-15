/**
 * 
 */
package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/reverse-string-ii/
 * 
 Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ReverseString2 {
	// both methods are equally faster but this one is 
	// will less lines of code
	public String reverseStr(String s, int k) {

		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i += (2 * k)) // Reverse the first k characters for every 2k characters
			reverseCharArray(arr, i, Math.min(arr.length - 1, (i + k - 1))); // If there are less than k characters left, reverse the remaining characters

		return new String(arr);
	}

	public String reverseStr1(String s, int k) {
		char[] arr = s.toCharArray();
		int len = s.length();
		int div = len/k;
		int count = 1;
		int start = 0;
		int end = k - 1;
		while((count <= div) && end < len - 1){
			reverseCharArray(arr, start, end);
			count++;
			start = end + k + 1;
			end = start + k - 1;
		}

		end = s.length() - 1;
		if(start < end)
			reverseCharArray(arr, start, end);
		return new String(arr);
	}
	public void reverseCharArray(char[] arr, int start, int end) {
		char temp;
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}
	public static void main(String[] args) {
		ReverseString2 reverseString2 = new ReverseString2();
		String s1 = "abcdefgijk";
		int k1 = 4;

		System.out.println(reverseString2.reverseStr(s1, k1));
	}

}
