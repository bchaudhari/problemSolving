package com.bk;

import java.awt.print.Printable;
import java.util.Arrays;

import com.bk.utils.Printer;

/**
 * Leetcode - https://leetcode.com/problems/merge-sorted-array/ 
 * 
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MergeSortedArray {
	// both solutions are equally fast but below one is simple to write
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int count = 0;
		for(int i = m; i < m + n; i++) {
			nums1[i] = nums2[count];
			count++;
		}
		
		Arrays.sort(nums1);
	}

	
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int first = m-1;
		int second = n-1;
		for(int i = m + n - 1; i >= 0; i--) { 
			if (second < 0) {
				nums1[i] = nums1[first];
				first--;
			} else if(first < 0) {
				nums1[i] = nums2[second];
				second--;
			} else if(nums1[first] > nums2[second]) {
				nums1[i] = nums1[first];
				first--;
			} else {
				nums1[i] = nums2[second];
				second--;
			}
		}
	}

	public static void main(String[] args) {
		MergeSortedArray mergeSortedArray = new MergeSortedArray();

		int[] nums1 = {1,2,3,0,0,0};
		int m1 = 3;
		int[] nums2 = {2,5,6};
		int n2 = 3;

		int[] nums3 = {0,0,8,9,0,0,0};
		int m3 = 4;
		int[] nums4 = {2,5,6};
		int n4 = 3;

		int[] nums5 = {-1,0,0,0,3,0,0,0,0,0,0};
		int m5 = 5;
		int[] nums6 = {-1,-1,0,0,1,2};
		int n6 = 6;

		int[] nums7 = {0};
		int m7 = 0;
		int[] nums8 = {1};
		int n8 = 1;

		mergeSortedArray.merge(nums1, m1, nums2, n2);
		Printer.printArray(nums1);

		System.out.println("\n");

		mergeSortedArray.merge(nums3, m3, nums4, n4);
		Printer.printArray(nums3);

		System.out.println("\n");

		mergeSortedArray.merge(nums5, m5, nums6, n6);
		Printer.printArray(nums5);

		System.out.println("\n");

		mergeSortedArray.merge(nums7, m7, nums8, n8);
		Printer.printArray(nums7);

	}
}
