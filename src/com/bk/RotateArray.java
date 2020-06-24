package com.bk;

import java.util.Arrays;
import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/rotate-array/
 * 
 Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:

Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 2 * 10^4
It's guaranteed that nums[i] fits in a 32 bit-signed integer.
k >= 0
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class RotateArray {

	// Runtime 0 ms
	// O(1) space complexity
	public void rotate(int[] nums, int k) {
		int count = 0;
		k = k % nums.length;
		for(int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[current];
			do {
				int next = (current + k) % nums.length;
				
				// swap prev and nums[next]
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				count++;
				
				current = next;		
			} while(current != start);
		}
	}
	
	// SUPER SLOW APPROACH - NEVER USE
	// Runtime 218 ms
	// Faster than 8.44%
	// O(1) - constant space
	public void rotate2(int[] nums, int k) {
		while(k > 0) {
			int prev = nums[0];
			for(int i = 1; i < nums.length; i++) {
				//Swap prev and nums[i]
				int tmp = nums[i];
				nums[i] = prev;
				prev = tmp;
			}
			nums[0] = prev;
			k--;
		}
	}
	
	// Runtime 0 ms
	// Faster than 100
	// O(n) space complexity
	public void rotate1(int[] nums, int k) {
		int[] temp = Arrays.copyOf(nums, nums.length);

		for(int i = 0; i < temp.length; i++) {
			int newPosition = i + k;
			
			// DO NOT use IF here. With that you will get 
			// out of bound exception if k > length
			while(newPosition > temp.length - 1) {
				newPosition = newPosition - temp.length;
			}
			nums[newPosition] = temp[i];
		}
	}

	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		int[] nums1 = {1,2,3,4,5,6,7};
		rotateArray.rotate(nums1,3);
		Printer.printArray(nums1);
		
		int[] nums2 = {1};
		rotateArray.rotate(nums2,3);
		Printer.printArray(nums2);
		
		int[] nums3 = {1,2,3,4};
		rotateArray.rotate(nums3,2);
		Printer.printArray(nums3);
	}

}
