package educative.twoPointers;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; 
 * after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 * 
 * 
 * Example 1:
 * Input: [2, 3, 3, 3, 6, 9, 9] 
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 *
 * Example 2:
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 * 
 * @author bk
 *
 */
public class RemoveDuplicates {

	public static int remove(int[] a) {
		int left = 0;
		int right = 1;
		
		while(right < a.length) {
			if(a[left] != a[right]) {
				left++;
				a[left] = a[right];
			}
			right++;
		}
		return left+1;
	}
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
	    System.out.println(RemoveDuplicates.remove(arr));

	    arr = new int[] { 2, 2, 2, 11 };
	    System.out.println(RemoveDuplicates.remove(arr));

	}

}
