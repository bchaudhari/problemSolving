package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/repeated-string-match/
 * 
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		if(A.contains(B))
			return 1;
		int bLength = B.length();
		int aLength = A.length();
		int floor = bLength / aLength;
		int bFirstCharPostionInA = A.indexOf(B.charAt(0));
		int maxRepeat = floor + bFirstCharPostionInA + 2;
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= maxRepeat; i++) {
			sb.append(A);
			if(i >= floor && sb.toString().contains(B))
				return i;
		}
		return -1;       
	}
	public static void main(String[] args) {
		String A1 = "abcd";
		String B1 = "cdabcdab";
		String A2 = "a";
		String B2 = "aa";
		String A3 = "aa";
		String B3 = "a";
		String A4 = "bb";
		String B4 = "bbbbbbb";
		String A5 = "acd";
		String B5 = "cdacdk";
		String A6 = "abababaaba";
		String B6 = "aabaaba";
		RepeatedStringMatch match = new RepeatedStringMatch();
		System.out.println("Expected 3 found --> " + match.repeatedStringMatch(A1, B1));
		System.out.println("Expected 2 found --> " + match.repeatedStringMatch(A2, B2));
		System.out.println("Expected 1 found --> " + match.repeatedStringMatch(A3, B3));
		System.out.println("Expected 4 found --> " + match.repeatedStringMatch(A4, B4));
		System.out.println("Expected -1 found --> " + match.repeatedStringMatch(A5, B5));
		System.out.println("Expected 2 found --> " + match.repeatedStringMatch(A6, B6));
	}
}
