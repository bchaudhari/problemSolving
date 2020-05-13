package com.bk;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.bk.utils.Printer;

/***
 * Leetcode - https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class ArrayIntersection {
	public int[] intersection(int[] nums1, int[] nums2) {
		int n1 = nums1.length;
		int n2 = nums2.length;
		if(n1 < n2){
			return findCommonElements(nums1, nums2);
		} else {
			return findCommonElements(nums2, nums1);
		}
	}

	public int[] findCommonElements(int[] a1, int[] a2){
		Set<Integer> list = new HashSet<Integer>();
		// Convert long array to Set
		Set<Integer> a2Set = new HashSet<Integer>();
		for(int x: a2) a2Set.add(x);

		for(int y: a1){
			if(a2Set.contains(y)){
				list.add(y);
			}
		}

		int[] result = new int[list.size()];
		Iterator<Integer> itr = list.iterator();
		int count = 0;
		while(itr.hasNext()){
			result[count] = (int) itr.next();
			count++;
		}
		return result;
	}
	public static void main(String[] args) {
		ArrayIntersection arrayIntersection = new ArrayIntersection();
		
		int[] A1a = {1, 2, 2, 1};
		int[] A1b = {2, 2};
		
		int[] A2a = {4, 9, 5};
		int[] A2b = {9, 4, 9, 8, 4};
		
		int[] A3a = {1, 2, 3};
		int[] A3b = {};
		
		Printer.printArray(arrayIntersection.intersection(A1a, A1b));
		Printer.printArray(arrayIntersection.intersection(A2a, A2b));
		Printer.printArray(arrayIntersection.intersection(A3a, A3b));
		
		
	}
}
