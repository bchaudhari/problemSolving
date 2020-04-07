package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/can-place-flowers/
 
 Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
Note:
The input array won't violate no-adjacent-flowers rule.
The input array size is in the range of [1, 20000].
n is a non-negative integer which won't exceed the input array size.
 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class FlowerBed {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int curr, next, prev;
		if(flowerbed.length == 1) {
			if(flowerbed[0] == 0) {
				n--;
			}
		} 
		else {
			for(int i = 0; i < flowerbed.length; i++) {
                if(n == 0) {
					return true;
				}
				curr = flowerbed[i];
				if(i == 0) {
					next = flowerbed[i+1];
					if(curr == 0 && next == 0) {
						flowerbed[i] = 1;
						n--;
					}
				}
				else if(i == flowerbed.length-1) {
					prev = flowerbed[i-1];
					if(prev == 0 && curr == 0) {
						flowerbed[i] = 1;
						n--;
					}
				} else {
					next = flowerbed[i+1];
					prev = flowerbed[i-1];
					if(curr == 0 && next == 0 && prev == 0) {
						flowerbed[i] = 1;
						n--;
					}		
				}
			}
		}
		return n <= 0;
	}
	public boolean canPlaceFlowers1(int[] flowerbed, int n) {
		for(int i = 0; i < flowerbed.length-1; i = i+2) {
			int current = flowerbed[i];
			int next = flowerbed[i+1];

			if(current == 0) {
				if(next == 0) {
					flowerbed[i] = 1;
					n--;
				} else {
					continue;
				}
			} else if(current == 1) {
				if(next == 0) {
					continue;
				} else {
					return false;
				}
			}
		}

		if(flowerbed.length == 1) {
			if(flowerbed[0] == 0) {
				n--;
			}
		}
		// if array has odd number of elements
		// and last 2 elements are 0 then last element can be 1.
		else if(flowerbed.length % 2 != 0) {
			if(flowerbed[flowerbed.length-2] == 0 && flowerbed[flowerbed.length-1] == 0) {
				n--;
			}
		}
		return n <= 0;
	}

	public static void main(String[] args) {
		int[] flowerbed1 = {1,0,0,0,1};
		int n1 = 1;
		int[] flowerbed2 = {1,0,0,0,1};
		int n2 = 2;
		int[] flowerbed3 = {1,0,0,0,0,1};
		int n3 = 2;
		int[] flowerbed4 = {0,0,1,0,1};
		int n4 = 1;
		int[] flowerbed5 = {1,0,0,0,1,0,0};
		int n5 = 2;
		int[] flowerbed6 = {1};
		int n6 = 1;
		int[] flowerbed7 = {0};
		int n7 = 1;
		int[] flowerbed8 = {0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0};
		int n8 = 17;
		int[] flowerbed9 = {1,0,0,0,0,0,1};
		int n9 = 2;
		FlowerBed fb = new FlowerBed();
		System.out.println("Expected true Found --> " + fb.canPlaceFlowers(flowerbed1, n1));
		System.out.println("Expected false Found --> " + fb.canPlaceFlowers(flowerbed2, n2));
		System.out.println("Expected false Found --> " + fb.canPlaceFlowers(flowerbed3, n3));
		System.out.println("Expected true Found --> " + fb.canPlaceFlowers(flowerbed4, n4));
		System.out.println("Expected true Found --> " + fb.canPlaceFlowers(flowerbed5, n5));
		System.out.println("Expected true Found --> " + fb.canPlaceFlowers(flowerbed6, n6));
		System.out.println("Expected true Found --> " + fb.canPlaceFlowers(flowerbed7, n7));
		System.out.println("Expected false Found --> " + fb.canPlaceFlowers(flowerbed8, n8));
		System.out.println("Expected true Found --> " + fb.canPlaceFlowers(flowerbed9, n9));
	}

}
