package com.bk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/next-greater-element-i/
 * 
 You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class NextGreaterElement1 {
	// Run time 7 ms on leetcode 
	// Faster than 23%
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		for(int i = 0; i < nums1.length; i++) {
			int j = 0;
			while(nums2[j++] != nums1[i]);
			int greaterNum = -1;
			while(j < nums2.length) {
				if(nums2[j] > nums1[i]) {
					greaterNum = nums2[j];
					break;
				}
				j++;
			}
			result[i] = greaterNum;
		}
		return result;
	}

	// Runtime 4 ms on leetcode
	// Faster than 69.55%
	public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Stack<Integer> stack = new Stack<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for(int i = 0; i < nums2.length; i++) {
			while(!stack.isEmpty() && nums2[i] > stack.peek()) {
				hm.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}

		for(int i = 0; i < nums1.length; i++) {
			result[i] = hm.getOrDefault(nums1[i], -1);
		}

		return result;
	}

	// Runtime 3 ms on leetcode
	// Faster than 84%
	// Solution is similar to above 1 except using linked list instead of stack
	public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		LinkedList<Integer> list = new LinkedList<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for(int i = 0; i < nums2.length; i++) {
			while(!list.isEmpty() && nums2[i] > list.getLast()) {
				hm.put(list.removeLast(), nums2[i]);
			}
			list.add(nums2[i]);
		}

		for(int i = 0; i < nums1.length; i++) {
			result[i] = hm.getOrDefault(nums1[i], -1);
		}

		return result;
	}



	public static void main(String[] args) {
		int[] n1 = {4,1,2};
		int[] n2 = {1,3,4,2};
		int[] n3 = {2,4};
		int[] n4 = {1,2,3,4};

		NextGreaterElement1 nextGreaterElement = new NextGreaterElement1();
		Printer.printArray(nextGreaterElement.nextGreaterElement2(n1, n2));		
		Printer.printArray(nextGreaterElement.nextGreaterElement2(n3, n4));

	}

}
