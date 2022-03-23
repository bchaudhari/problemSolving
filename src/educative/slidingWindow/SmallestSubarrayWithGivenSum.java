package educative.slidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘S,’
 * find the length of the smallest contiguous subarray whose 
 * sum is greater than or equal to ‘S’. Return 0 if no such 
 * subarray exists.
 * 
 * Example 1:
 * Input: [2, 1, 5, 2, 3, 2], S= 7 
 * Output: 2
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
 *
 * Example 2:
 * Input: [2, 1, 5, 2, 8], k=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * 
 * Example 3:
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] 
 * or [1, 1, 6].
 * 
 * @author bk
 *
 */
public class SmallestSubarrayWithGivenSum {

	public static int smallestSubArray(int[] arr, int s) {
		int min = Integer.MAX_VALUE;
		int start = 0; 
		int end = 0;
		int sum = 0;
		
		while(end < arr.length) {
			sum += arr[end];
			while(sum >= s) {
				min = Math.min(min, (end-start+1));
				sum = sum - arr[start];
				start++;
			}
			end++;
		}
		return min;
	}
	public static void main(String[] args) {
		int[] arr1 = {2, 1, 5, 2, 3, 2};
		int s1 = 7;
		int out1 = smallestSubArray(arr1, s1);
		System.out.println(out1);
		
		int[] arr2 = {2, 1, 5, 2, 8};
		int s2 = 7;
		int out2 = smallestSubArray(arr2, s2);
		System.out.println(out2);
		
		int[] arr3 = {3, 4, 1, 1, 6};
		int s3 = 8;
		int out3 = smallestSubArray(arr3, s3);
		System.out.println(out3);

	}

}
