package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/add-binary/
 * 
   Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

Each string consists only of '0' or '1' characters.
1 <= a.length, b.length <= 10^4
Each string is either "0" or doesn't contain any leading zero.
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class AddBinary {
	// Using XOR
	public String addBinary2(String a, String b) {
        if(a == null || a.isEmpty()) 
            return b;
        if(b == null || b.isEmpty()) 
            return a;
    
        
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int aBit;
        int bBit;
        int carry = 0;
        int result;

        while(i >= 0 || j >= 0 || carry == 1) {
            aBit = (i >= 0) ? Character.getNumericValue(a.charAt(i--)) : 0;
            bBit = (j >= 0) ? Character.getNumericValue(b.charAt(j--)) : 0;
            result = aBit ^ bBit ^ carry;
            carry = ((aBit + bBit + carry) >= 2) ? 1 : 0;
            sb.append(result);
        }
        return sb.reverse().toString();
    }
	
	// Runtime 2 ms
	// Faster than 76.97% on leetcode
	public String addBinary1(String a, String b) {
		int n1 = a.length() - 1;
		int n2 = b.length() - 1;
		int n = n1 > n2 ? n1 : n2;
		int cf = 0;
		StringBuffer result = new StringBuffer();
		
		for(int i = 0; i <= n; i++) {
			int x = n1 - i >= 0 ? Character.getNumericValue(a.charAt(n1 - i)) : 0;
			int y = n2 - i >= 0 ? Character.getNumericValue(b.charAt(n2 - i)) : 0;
			int sum = x + y + cf;	
			
			result.append(sum % 2);
			cf = sum / 2;
		}
		
		if(cf == 1) result.append(1);
		return result.reverse().toString();
	}
	public static void main(String[] args) {
		AddBinary add = new AddBinary();
		System.out.println(add.addBinary1("0", "11111"));

	}

}
