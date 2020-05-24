package com.bk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * Leetcode - https://leetcode.com/problems/majority-element-ii/
 * 
Given an integer array of size n, find all elements that appear more than n/3 times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MajorityElement2 {
	
	// Little faster
	public List<Integer> majorityElement(int[] nums) {
		int n = nums.length;
		int counter = 1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(n == 1) {
			result.add(nums[0]);
			return result;
		}
		
		Arrays.sort(nums);
		for(int i = 0; i < n; i++) {
			if(!result.contains(nums[i]) && counter > n/3) {
				result.add(nums[i]);
			}
			
			if(i < n-1 && nums[i] == nums[i+1]) {
				counter++;
				
			} else {
				counter = 1;
			}
		}
		return result;
	}
	// Slower solution
	// Space complexity O(n)
	public List<Integer> majorityElement1(int[] nums) {
		int n = nums.length;
		List<Integer> result = new ArrayList<Integer>();
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int val = 0;
		int count =  0;
		for(int x: nums) {
			val = ht.containsKey(x)? ht.get(x) + 1: 1;
			ht.put(x, val);
		}
		
		Set<Integer> keyset = ht.keySet();
		for(int key: keyset) {
			count = ht.get(key);
			if(count > n/3) {
				result.add(key);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,1,1,3,3,3,2,2,2};
		int[] nums2 = {1,2};

		MajorityElement2 majorityElement = new MajorityElement2();
		System.out.println(majorityElement.majorityElement(nums1));
		System.out.println(majorityElement.majorityElement(nums2));

	}

}
