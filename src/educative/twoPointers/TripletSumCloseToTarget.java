package educative.twoPointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number, find a triplet 
 * in the array whose sum is as close to the target number as possible, 
 * return the sum of the triplet. If there are more than one such triplet, 
 * return the sum of the triplet with the smallest sum.
 * 
 * Example 1:
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 *
 * Example 2:
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * 
 * @author bk
 *
 */
public class TripletSumCloseToTarget {

	public static int searchTriplet(int[] nums, int target){
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length && diff != 0; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while(left < right) {
				int sum =  nums[i] + nums[left] + nums[right];
				
				if(Math.abs(target - sum) < Math.abs(diff)) {
					diff = target - sum;
				}
				
				if(sum < target) {
					left++;
				}
				else{
					right--;
				}	
			}
		}
		return target - diff;
	}

	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}

}
