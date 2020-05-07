package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class SmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int n = letters.length;
		char result;
		if(target >= letters[n-1]) 
			result = letters[0];
		else {
			int index =  binarySearch(letters, 0, n-1, (char)(target + 1));
			if(letters[index] >= (char)(target + 1)) {
				result = letters[index];
			} else {
				result = letters[index + 1]; 
			}
		}
		return result;
	}
	public int binarySearch(char[] letters, int left, int right, char target) {
		
		if(left <= right) {
			
			int mid = left + (right - left)/2;
			if(letters[mid] == target) {
				return mid;
			}
			else if(target < letters[mid]) {
				right = mid - 1;
				return binarySearch(letters, left, right, target);
			}
			else if(target > letters[mid]) {
				left = mid + 1;
				return binarySearch(letters, left, right, target);
			}
		}
		return left;		
	}
	public static void main(String[] args) {
		SmallestLetterGreaterThanTarget smallest = new SmallestLetterGreaterThanTarget();
		
		char[] letters1 = {'c', 'f', 'j'};
		char target1 = 'a';

		System.out.println("Expected c found --> " + smallest.nextGreatestLetter(letters1, target1));
		
		char[] letters2 = {'c', 'f', 'j'};
		char target2 = 'c';

		System.out.println("Expected f found --> " + smallest.nextGreatestLetter(letters2, target2));
	
		char[] letters3 = {'c', 'f', 'j'};
		char target3 = 'd';

		System.out.println("Expected f found --> " + smallest.nextGreatestLetter(letters3, target3));
		
		char[] letters4 = {'c', 'f', 'j'};
		char target4 = 'g';

		System.out.println("Expected j found --> " + smallest.nextGreatestLetter(letters4, target4));

		char[] letters5 = {'c', 'f', 'j'};
		char target5 = 'j';

		System.out.println("Expected c found --> " + smallest.nextGreatestLetter(letters5, target5));

		char[] letters6 = {'c', 'f', 'j'};
		char target6 = 'k';

		System.out.println("Expected c found --> " + smallest.nextGreatestLetter(letters6, target6));
		
		char[] letters7 = {'a', 'a', 'a', 'a', 'a', 'a', 'c', 'd', 'd', 'e','e','e'};
		char target7 = 'b';

		System.out.println("Expected c found --> " + smallest.nextGreatestLetter(letters7, target7));
		
		char[] letters8 = {'a', 'a', 'a', 'a', 'a', 'd', 'd', 'e','e','e'};
		char target8 = 'b';

		System.out.println("Expected d found --> " + smallest.nextGreatestLetter(letters8, target8));
			
	}

}
