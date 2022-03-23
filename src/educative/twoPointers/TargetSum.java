package educative.twoPointers;

/**
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * 
 * 
 * Example 1:
 * Input: [1, 2, 3, 4, 6], target=6 
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 *
 * Example 2:
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 * 
 * @author bk
 *
 */
public class TargetSum {

	public static int[] twoSum(int[] a, int target) {
		int start = 0;
		int end = a.length - 1;
		int sum = 0;
		while(start != end) {
			sum = a[start] + a[end];
			if(sum > target) {
				end--;
			}
			else if (sum < target) {
				start++;
			}
			else {
				return new int[] {start, end};
			}
		}
		return new int[] {-1,-1};

	}
	public static void main(String[] args) {
		int[] result = twoSum(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
		result = twoSum(new int[] { 2, 5, 9, 11 }, 11);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
	}

}
