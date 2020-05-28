package com.bk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode - https://leetcode.com/problems/k-diff-pairs-in-an-array/
 * 
 Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
 *
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class KDiffPair {

	// Faster approach - Easy to understand solution
	// Space complexity O(n)
	public int findPairs(int[] nums, int k) {
		if(k < 0)
			return 0;

		int result = 0;

		// If k = 0, just check how many numbers are repeated
		if(k == 0) {
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			for(int num: nums) {
				int val = hm.getOrDefault(num, 0);
				hm.put(num, val+1);
			}

			for(int val: hm.values()) {
				if(val > 1) {
					result++;
				}
			}	
		} 
		else {
			Set<Integer> set = new HashSet<Integer>();
			for(int num: nums) {
				set.add(num);
			}
			for(int num: set) {
				int pair = num + k;
				if(set.contains(pair)) {
					result++;
				}
			}
		}
		return result;
	}

	// Fastest approach with two pointers
	// Hard to understand
	// Space complexity O(1)
	public int findPairs2(int[] nums, int k) {
		if(k < 0)
			return 0;
		Arrays.sort(nums);

		int result = 0;
		int left = 0;
		int right = left + 1;

		while(left < right && right < nums.length) {
			int diff = nums[right] - nums[left];
			if(diff < k) {
				while(++right < nums.length && nums[right] == nums[right-1]) {
					continue;
				}

			} 
			else {
				if (diff == k) {
					result++;

				}
				while(++left < nums.length && nums[left] == nums[left-1]) {
					continue;
				}
				if(right <= left) {
					right = left + 1;
				}
			}
		}

		return result;
	}

	// Very slow 
	// O(n2)
	// Time Exceeded on Leetcode submission
	public int findPairs1(int[] nums, int k) {
		if(k < 0)
			return 0;

		int result = 0;
		Set<Integer> keys = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(i == j) {
					continue;
				}
				if(!keys.contains(nums[j]) && (nums[i] - nums[j] == k)){
					result++;
					keys.add(nums[j]);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums1 = {3, 1, 4, 1, 5};
		int k1 = 2;

		int[] nums2 = {3, 1, 4, 1, 1, 5};
		int k2 = 0;

		int[] nums3 = {1, 2, 3, 4, 5};
		int k3 = -1;

		int[] nums4 = {1};
		int k4 = 0;

		int[] nums5 = {1, 1, 1, 2, 1};
		int k5 = 1;

		int[] nums6 = {-1,0,1,-2,0};
		int k6 = 2;


		KDiffPair kDiffPair = new KDiffPair();
		//		System.out.println(kDiffPair.findPairs(nums1, k1));
		//		System.out.println(kDiffPair.findPairs(nums2, k2));
		//		System.out.println(kDiffPair.findPairs(nums3, k3));
		//		System.out.println(kDiffPair.findPairs(nums4, k4));
		//		System.out.println(kDiffPair.findPairs(nums5, k5));
		System.out.println(kDiffPair.findPairs(nums6, k6));
	}

}
