package com.bk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/***
 * Leetcode - https://leetcode.com/problems/rank-transform-of-an-array/
 *
 Given an array of integers arr, replace each element with its rank.

The rank represents how large the element is. The rank has the following rules:

Rank is an integer starting from 1.
The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
Rank should be as small as possible.
 

Example 1:

Input: arr = [40,10,20,30]
Output: [4,1,2,3]
Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
Example 2:

Input: arr = [100,100,100]
Output: [1,1,1]
Explanation: Same elements share the same rank.
Example 3:

Input: arr = [37,12,28,9,100,56,80,5,12]
Output: [5,3,4,2,8,6,7,1,3]
 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */

public class ArrayRankTransform {
	public int[] arrayRankTransformImproved(int[] arr) {
	   int[] temp = Arrays.copyOf(arr, arr.length);
	   Arrays.sort(temp);
	   int counter = 1;
	   HashMap<Integer, Integer> numberRank = new HashMap<Integer, Integer>();
	   for(int x: temp) {
		 if(!numberRank.containsKey(x)) {
			 numberRank.put(x, counter);
			 counter++;
		 }
	   }
	   
	   int[] result = new int[arr.length];
	   for(int i = 0; i < arr.length; i++) {
		   result[i] = numberRank.get(arr[i]);
	   }
	   
	   return result;
    }
	public int[] arrayRankTransform1(int[] arr) {
		   // Convert Array to ArrayList
	       List<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toList());
	       
	       // Convert ArrayList to TreeSet so that duplicates are removed and elements are sorted
	       Set<Integer> treeSet = new TreeSet<Integer>(al);
	       
	       // Convert Treeset to ArrayList so that we can fetch index based on element
	       al = new ArrayList<Integer>(treeSet);
	       
	       for(int i = 0; i < arr.length; i++) {
	    	   arr[i] = al.indexOf(arr[i]) + 1;
	       }
	       return arr;
	    }
	
	public void printArray(int[] arr) {
		System.out.print("\n[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]\n");
	}
	public static void main(String[] args) {
		int[] A1 = {40,10,20,30};
		int[] A2 = {100, 100, 100};
		int[] A3 = {37,12,28,9,100,56,80,5,12};
		
		ArrayRankTransform arrayRank = new ArrayRankTransform();
		arrayRank.printArray(arrayRank.arrayRankTransformImproved(A1));
		arrayRank.printArray(arrayRank.arrayRankTransformImproved(A2));
		arrayRank.printArray(arrayRank.arrayRankTransformImproved(A3));

	}

}
