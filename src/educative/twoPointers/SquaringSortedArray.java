package educative.twoPointers;

/**
 * Given a sorted array, create a new array containing squares of all the numbers of the input 
 * array in the sorted order.
 * 
 * Example 1:
 * Input: [-2, -1, 0, 2, 3] 
 * Output: [0, 1, 4, 4, 9]
 * 
 * Example 2:
 * Input: [-3, -1, 0, 1, 2]
 * Output: [0, 1, 1, 4, 9]
 * 
 * @author bk
 *
 */
public class SquaringSortedArray {

	public static int[] generate(int[] a) {
		int[] result = new int[a.length];
		int left = 0;
		int right = a.length - 1;
		int highestSquareIndex = a.length - 1;
		
		while(left <= right) {
			int rightSqr = a[right] * a[right];
			int leftSqr = a[left] * a[left];
			
			if(leftSqr > rightSqr) {
				result[highestSquareIndex--] = leftSqr;
				left++;
			} else {
				result[highestSquareIndex--] = rightSqr;
				right--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] result = generate(new int[] {-2, -1, 0, 2, 3});

		for (int num : result)
			System.out.print(num + " ");
		System.out.println();
		
		result = generate(new int[] {-3, -1, 0, 1, 2});
		for (int num : result)
			System.out.print(num + " ");
		System.out.println();
	}

}
