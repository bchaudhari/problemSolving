package educative.twoPointers;

import java.util.*;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that 
 * arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. 
 * Write a function to return the count of such triplets.
 * 
 * Example 1:
 * Input: [-1, 0, 2, 3], target=3 
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 *
 * Example 2:
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target: 
 *              [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 * 
 * @author bk
 *
 */
public class TripletSumSmallerThanTarget {

	public static int searchTriplet(int[] a, int target){
		if(a == null || a.length <= 3) {
			throw new IllegalArgumentException();
		}
		int count = 0;
		Arrays.sort(a);
		
		for(int i = 0; i < a.length-2; i++) {
			int left = i + 1;
			int right = a.length - 1;
			while(left < right) {
				int sum = a[i] + a[left] + a[right];
				
				if(sum < target) {
					count = count + right - left;
					left++;
				}
				else {
					right--;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(TripletSumSmallerThanTarget.searchTriplet(new int[] { -1, 0, 2, 3 }, 3));
		System.out.println(TripletSumSmallerThanTarget.searchTriplet(new int[] { -1, 4, 2, 1, 3 }, 5));
	}

}
