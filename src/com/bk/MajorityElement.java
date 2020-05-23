package com.bk;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * Leetcode - https://leetcode.com/problems/majority-element/
 * 
 Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 imes.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MajorityElement {

	// Faster solution
	// Since majority element will be repeated more than n/2 times
	// For a sorted array element at n/2 position will be the majority element 
	// this is true for both even and odd number of elements in Array
	public int majorityElement(int[] nums) {
		int n = nums.length;
		Arrays.sort(nums);
		return nums[n/2];
	}
	
	// Slower solution
	public int majorityElement1(int[] nums) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int maxVal = 0;
		int maxKey = 0;
		int val = 0;
		for(int x: nums) {
			val = ht.containsKey(x)? ht.get(x) + 1: 1;
			ht.put(x, val);
			if(val > maxVal) {
				maxVal = val;
				maxKey = x;
			}
		}
		return maxKey;
	}

	public static void main(String[] args) {
		int[] nums1 = {2,2,1,1,1,2,2};
		int[] nums2 = {1};

		MajorityElement majorityElement = new MajorityElement();
		System.out.println(majorityElement.majorityElement(nums1));
		System.out.println(majorityElement.majorityElement(nums2));

	}

}
