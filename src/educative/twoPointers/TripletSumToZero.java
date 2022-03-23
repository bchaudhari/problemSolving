package educative.twoPointers;

import java.util.*;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * 
 * Example 1:
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 *
 * Example 2:
 * Input: [-5, 2, -1, -2, 3]
 * Output: [[-5, 2, 3], [-2, -1, 3]]
 * Explanation: There are two unique triplets whose sum is equal to zero.
 * 
 * @author bk
 *
 */
public class TripletSumToZero {

	public static List<List<Integer>> searchTriplets(int[] a){
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(a);

		for(int i = 0; i < a.length-1; i++) {
			if(i > 0 && a[i+1] == a[i]) {
				continue; // Skip duplicates
			}
			int targetSum = -a[i];
			int left = i+1;
			findSumPair(a, targetSum, left, triplets);
		}
		return triplets;
	}

	private static void findSumPair(int[] a, int targetSum, int left, List<List<Integer>> triplets) {
		int right = a.length - 1;
		while(left < right) {
			int sum = a[left] + a[right];
			if(sum == targetSum) {
				triplets.add(Arrays.asList(-targetSum, a[left], a[right]));
				left++;
				right--;
				while(left < right && a[left] == a[left - 1]) {
					left++; // skip duplicates
				}
				while(left < right && a[right] == a[right + 1]) {
					right--; // skip duplicates
				}
			}
			if(sum > targetSum) {
				right--;
			}
			if(sum < targetSum) {
				left++;
			}
		}
	}
	public static void main(String[] args) {
		System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
	    System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
	}

}
