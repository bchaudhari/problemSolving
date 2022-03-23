package educative.slidingWindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace 
 * no more than ‘k’ 0s with 1s, find the length of the longest contiguous 
 * subarray having all 1s.
 * 
 * Example 1:
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest 
 * contiguous subarray of 1s having length 6.
 * 
 * Example 2:
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest 
 * contiguous subarray of 1s having length 9.
 * 
 * @author bk
 *
 */
public class LongestSubstringAfterReplacingZerosWithOnes {

	public int findLength(int[] arr, int k) {
		int start = 0;
		int maxLen = 0;
		// count of max 1's in window
		int maxCount = 0;
		
		for(int end = 0; end < arr.length; end++) {
			if(arr[end] == 1) {
				maxCount++;
			}
			
			while(end - start + 1 - maxCount > k) {
				if(arr[start] == 1) {
					maxCount--;
				}
				start++;
			}
			maxLen = Math.max(maxCount, end - start + 1);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		LongestSubstringAfterReplacingZerosWithOnes ls = new LongestSubstringAfterReplacingZerosWithOnes();

		// Example 1
		int[] arr1 = new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
		int k1 = 2;
		int out1 = ls.findLength(arr1, k1);
		System.out.println(out1);

		// Example 2
		int[] arr2 = new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		int k2 = 3;
		int out2 = ls.findLength(arr2, k2);
		System.out.println(out2);
	}

}
