package educative.slidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k,’ 
 * find the maximum sum of any contiguous subarray of size ‘k’.
 * 
 * Example 1:
 * Input: [2, 1, 5, 1, 3, 2], k=3 
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 *
 * Example 2:
 * Input: [2, 3, 4, 1, 5], k=2 
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 * 
 * @author bk
 *
 */
public class MaxSubarray {
	
	public static int maxSubarray(int[] arr, int k) {
		int maxSum = 0;
		int winSum = 0;
		int start = 0;
		for(int end = 0; end < arr.length; end++) {
			winSum += arr[end];
			if(end >= k-1) {
				maxSum = Math.max(maxSum, winSum);
				winSum -= arr[start];
				start++;
			}					
		}
		return maxSum;
	}
	
	public static void main(String args[]) {
		int[] arr1 = {2, 1, 5, 1, 3, 2};
		int k1 = 3;
		
		int out1 = maxSubarray(arr1, k1);
		System.out.println(out1);
		
		int[] arr2 = {2, 3, 4, 1, 5};
		int k2 = 2;
		
		int out2 = maxSubarray(arr2, k2);
		System.out.println(out2);
		
	}

}
