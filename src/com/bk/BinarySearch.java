package com.bk;

/**
 * Leetcode - https://leetcode.com/problems/binary-search/
 * 
  Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 

Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
 * 
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class BinarySearch {
	// Without using recusion
	public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while(left <= right) {
        	// Very good explanation for not doing 
        	// mid = (left + right) / 2
        	// https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
        	// that can fail when we have more than a billion data (2^30). In this case 
        	// left + right can go above max value int can hold. Which in turn will return a negative number 
        	// and will get index out of bound exception
        	mid = left + ((right - left)/ 2);
        	
        	if(target == nums[mid]) {
        		return mid;
        	} else if(target < nums[mid]) {
        		right = mid - 1;
        	} else {
        		left = mid + 1;
        	}
        }
        // element not found
        return -1;
    }
	
	// Using recursion
	public int search1(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length -1, target);
    }
	// Using recursion
    public int binarySearch(int[] nums, int left, int right, int target){
        int mid = (left + right)/2;
        
        while(left <= right){
        if(target == nums[mid]){
            return mid;
        } else if(target < nums[mid]){
            return binarySearch(nums, left, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, right, target);
        }
        }
        return -1;
    }
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(new int[] {5}, 5));
		System.out.println(bs.search(new int[] {-1,0,3,5,9,12}, 9));
		System.out.println(bs.search(new int[] {-1,0,3,5,9,12}, 2));
	}

}

