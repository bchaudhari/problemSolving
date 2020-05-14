package com.bk;

import java.util.ArrayList;
import java.util.Arrays;

import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class IntersectionTwoArrays {

	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		 
		int n1 = 0;
		int n2 = 0;
		
		for(; n1 < nums1.length; n1++) {
			for(; n2 < nums2.length; n2++) {
				if(nums1[n1] == nums2[n2]) {
					al.add(nums1[n1]);
					n2++;
					break;
				}
				else if (nums1[n1] < nums2[n2]) {
					break;
				}
			}
		}
		
		int[] result = new int[al.size()];
		int count = 0;
		for(int a: al) {
			result[count] = a;
			count++;
		}
		return result;
	}

	public static void main(String[] args) {
		IntersectionTwoArrays intersection = new IntersectionTwoArrays();
		int[] a1 = {1,2,2,1};
		int[] a2 = {2,2};
		int[] b1 = {4,9,5};
		int[] b2 = {9,4,9,8,4};
		
		Printer.printArray(intersection.intersect(a1, a2));
		Printer.printArray(intersection.intersect(b1, b2));
	}

}
