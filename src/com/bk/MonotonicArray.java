package com.bk;

/***
 * https://leetcode.com/problems/monotonic-array/
 * 
 An array is monotonic if it is either monotone increasing or monotone decreasing.

An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

Return true if and only if the given array A is monotonic.

 

Example 1:

Input: [1,2,2,3]
Output: true
Example 2:

Input: [6,5,4,4]
Output: true
Example 3:

Input: [1,3,2]
Output: false
Example 4:

Input: [1,2,4,5]
Output: true
Example 5:

Input: [1,1,1]
Output: true
 

Note:

1 <= A.length <= 50000
-100000 <= A[i] <= 100000

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class MonotonicArray {
	public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for(int i = 1; i < A.length; i++) {
        	if(A[i] < A[i-1]) {
        		increasing = false;
        	} else if(A[i] > A[i-1]) {
        		decreasing = false;
        	} else if(!increasing && !decreasing) {
        		return false;
        	}    
        }
        
        return increasing || decreasing;
    }
	public static void main(String[] args) {
		int[] A1 = {1,2,2,3};
		int[] A2 = {6,5,4,4};
		int[] A3 = {1,3,2};
		int[] A4 = {1,2,4,5};
		int[] A5 = {1,1,1};
		
		MonotonicArray monotonicArray = new MonotonicArray();
		System.out.println("Expected true found --> " + monotonicArray.isMonotonic(A1));
		System.out.println("Expected true found --> " + monotonicArray.isMonotonic(A2));
		System.out.println("Expected false found --> " + monotonicArray.isMonotonic(A3));
		System.out.println("Expected true found --> " + monotonicArray.isMonotonic(A4));
		System.out.println("Expected true found --> " + monotonicArray.isMonotonic(A5));
	}

}
