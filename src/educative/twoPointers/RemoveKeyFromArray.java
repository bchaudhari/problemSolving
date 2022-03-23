package educative.twoPointers;

/**
 * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place 
 * and return the new length of the array.
 * 
 * Example 1:
 * Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
 * Output: 4
 * Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
 *
 * Example 2:
 * Input: [2, 11, 2, 2, 1], Key=2
 * Output: 2
 * Explanation: The first two elements after removing every 'Key' will be [11, 1].
 * 
 * @author bk
 *
 */
public class RemoveKeyFromArray {

	public static int remove(int[] a, int key) {
		int left = 0;
		int right = 0;
		for(right = 0; right < a.length; right++) {
			if(a[right] != key) {
				a[left] = a[right];
				left++;
			}
		}
		return left;
	}
	public static void main(String[] args) {
		System.out.println(remove(new int[] {3, 2, 3, 6, 3, 10, 9, 3}, 3));
		System.out.println(remove(new int[] {2, 11, 2, 2, 1}, 2));
	}

}
