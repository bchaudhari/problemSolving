package com.bk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/***
 * 
 * 
https://leetcode.com/problems/degree-of-an-array/
Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
Note:

nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ArrayDegree {
	public int findShortestSubArrayImproved(int[] nums) {
        int shortestLength = nums.length;
        
        // Hashmap to hold unique numbers as key and repetition count as value 
        HashMap<Integer, Integer> numRepetitionCount = new HashMap<Integer, Integer>();
        
        // Holds right index of each number
        HashMap<Integer, Integer> right = new HashMap<Integer, Integer>();
        
        // Holds left index of each number
        HashMap<Integer, Integer> left = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++) {
        	if(!numRepetitionCount.containsKey(nums[i])) {
        		numRepetitionCount.put(nums[i], 1);
        		left.put(nums[i], i);
        	} else {
        		numRepetitionCount.put(nums[i], numRepetitionCount.get(nums[i]) + 1);
        		right.put(nums[i], i);
        	}
        }
        
        // Find degree of Array
        Collection<Integer> col = numRepetitionCount.values();
        int degree = Collections.max(col);
        
        // Holds unique numbers which are repeating times of degree
        ArrayList<Integer> numsWithDegree = new ArrayList<Integer>();
        
        for(int x: numRepetitionCount.keySet()) {
        	if(numRepetitionCount.get(x) == degree) {
        		numsWithDegree.add(x);
        	}
        }
                
        for(int x: numsWithDegree) {
        	int length = right.get(x) - left.get(x) + 1;
        	shortestLength = Math.min(length, shortestLength);
        }
        return shortestLength;
    }
	public int findShortestSubArray(int[] nums) {
        int shortestLength = nums.length;
        
        // Hashmap to hold unique numbers as key and repetition count as value 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
        	if(!hm.containsKey(nums[i])) {
        		hm.put(nums[i], 1);
        	} else {
        		hm.put(nums[i], hm.get(nums[i]) + 1);
        	}
        }
        
        // Find degree of Array
        Collection<Integer> col = hm.values();
        int degree = Collections.max(col);
        
        // Holds unique numbers which are repeating times of degree
        ArrayList<Integer> numsWithDegree = new ArrayList<Integer>();
        
        for(int x: hm.keySet()) {
        	if(hm.get(x) == degree) {
        		numsWithDegree.add(x);
        	}
        }
                
        for(int x: numsWithDegree) {
        	int counter = 0;
        	int length = 0;
        	for(int i = 0; i < nums.length; i++) {
        		if(x == nums[i]) {
        			counter++;
        			if(counter == 1) {
        				length = i;
        			}
        			if(counter == degree) {
        				length = i - length + 1;
        				shortestLength = Math.min(shortestLength, length);
        			}
        		}
        	}
        }
        return shortestLength;
    }
	public static void main(String[] args) {
		int[] nums = {1, 2, 2, 3, 1};
		ArrayDegree ad = new ArrayDegree();
		System.out.println(ad.findShortestSubArrayImproved(nums));  
	}

}
