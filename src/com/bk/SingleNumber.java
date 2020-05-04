package com.bk;

import java.util.HashSet;
import java.util.Set;

/***
 * Leetcode - https://leetcode.com/problems/single-number/
 * 
 Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class SingleNumber {
	public int singleNumber(int[] nums) {
        Set<Integer> resultSet = new HashSet<Integer>();
        for(int x: nums){
            if(resultSet.contains(x)){
                resultSet.remove(x);
            } else {
                resultSet.add(x);
            }
        }
        
        return resultSet.iterator().next();
        
    }
	public static void main(String[] args) {
		int[] a1 = {2,2,1};
		int[] a2 = {4,1,2,1,2};
		
		SingleNumber number = new SingleNumber();
		System.out.println("Expected 1 found --> " + number.singleNumber(a1));
		System.out.println("Expected 4 found --> " + number.singleNumber(a2));		
	}
}
