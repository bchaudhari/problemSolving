package com.bk;

//https://leetcode.com/problems/search-insert-position/submissions/
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		int end = nums.length -1;
		int start = 0;
		int mid = 0;
		
		if(target <= nums[start]) {
			return start;
		} else if (target > nums[end]) {
			return end + 1;
		}
		
		while(start <= end) {

			mid = (start + end)/2;
			if(target == nums[mid]) {
				return mid;
			} else if(target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return start;
	}

	public static void main(String[] args) {
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] nums = {1,3};
		int target = 2;
		System.out.println(sip.searchInsert(nums, target));
	}
}
