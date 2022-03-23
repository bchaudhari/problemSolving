package educative.twoPointers;

import java.util.*;

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

	public static int searchTriplet(int[] a, int target){
		if(a == null || a.length <= 3) {
			throw new IllegalArgumentException();
		}
		
		Arrays.sort(a);
		int smallestDifference = Integer.MAX_VALUE;
		
		for(int i = 0; i < a.length-2; i++) {
			int left = i + 1;
			int right = a.length - 1;
			while(left < right) {
				int currentDiff = target - a[i] - a[left] - a[right];
				if(currentDiff == 0) {
					return target;
				}
				if(Math.abs(currentDiff) < Math.abs(smallestDifference) ||
						(Math.abs(currentDiff) == Math.abs(smallestDifference) &&
						currentDiff > smallestDifference)) {
					smallestDifference = currentDiff;
				}
				
				if(currentDiff > 0) {
					left++;
				}
				else if(currentDiff < 0) {
					right--;
				}	
			}
		}
		return target - smallestDifference;
	}

	public static void main(String[] args) {
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
		System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
	}

}
