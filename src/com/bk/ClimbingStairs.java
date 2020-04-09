package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/climbing-stairs/
 
 You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ClimbingStairs {
	
	public int climbStairs(int n) {
		int result = 0;
        if(n == 1) {
        	result = 1;
        }
        else if(n == 2) {
        	result = 2;
        } else {
        	result = climbStairs(n - 1) + climbStairs(n - 2);
        }
        return result;       
    }

	public static void main(String[] args) {
		ClimbingStairs climbingStairs = new ClimbingStairs();
		System.out.println(climbingStairs.climbStairs(45));
	}

}
