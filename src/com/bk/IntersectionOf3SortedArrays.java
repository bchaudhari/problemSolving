package com.bk;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - https://leetcode.com/problems/intersection-of-three-sorted-arrays/ (Problem #1213) 
 * Subscription required to see the problem
 * 
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 *
 * Example 1:
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 *
 * Constraints:
 *
 * 1 <= arr1.length, arr2.length, arr3.length <= 1000
 * 1 <= arr1[i], arr2[i], arr3[i] <= 2000
 * 
 * Strictly increasing meaning there is no duplicate in single array.
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class IntersectionOf3SortedArrays {
	public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
		List<Integer> result = new ArrayList<Integer>();
		int a1 = 0;
		int a2 = 0;
		int a3 = 0;
		
		while(a1 < arr1.length && a2 < arr2.length && a3 < arr3.length) {
			if(arr1[a1] == arr2[a2] && arr2[a2] == arr3[a3]) {
				result.add(arr1[a1]);
				a1++;
				a2++;
				a3++;
			} else if(arr1[a1] < arr2[a2]) {
				a1++;
			} else if(arr2[a2] < arr3[a3]) {
				a2++;
			} else {
				a3++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		IntersectionOf3SortedArrays intersection =  new IntersectionOf3SortedArrays();
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,5,7,9};
		int[] arr3 = {1,3,4,5,8};
		
		System.out.println(intersection.arraysIntersection(arr1, arr2, arr3));
	}
}
