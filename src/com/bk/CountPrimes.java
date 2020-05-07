package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/count-primes/
 * 
 Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class CountPrimes {

	// Faster solution
	public int countPrimes(int n) {
		int count = 0;
		boolean[] notPrime = new boolean[n];
		
		for(int i = 2; i < n; i++) {
			for(int j = i; i*j < n; j++) {
				notPrime[i*j] = true;
			}
		}
		
		for(int i = 2; i < n; i++) {
			if(!notPrime[i]) count++;
		}
		return count;
	}

	// Slower solution
	public int countPrimes1(int n) {
		int count = 0;
		for(int i = 1; i < n; i++) {
			if(isPrime1(i)) count++;
		}
		return count;
	}

	// Slower 
	public boolean isPrime1(int x) {
		if(x <= 1) return false;
		/*  Need to check till sqrt(x) only. See below example
		 	2 × 6 = 12
			3 × 4 = 12
			4 × 3 = 12
			6 × 2 = 12
			calculations of 4 × 3 and 6 × 2 are not necessary. 
		 */
		for(int i = 2; i*i <= x; i++) {
			if(x % i == 0) return false;
		}
		return true;
	}

//	// Faster 
//	public boolean isPrime(int x) {
//		if(x <= 1) return false;
//		/*  Need to check till sqrt(x) only. See below example
//			 	2 × 6 = 12
//				3 × 4 = 12
//				4 × 3 = 12
//				6 × 2 = 12
//				calculations of 4 × 3 and 6 × 2 are not necessary. 
//		 */
//		for(int i = 2; i*i <= x; i++) {
//			for(int j = i; j < x; j++) {
//				if(i * j == x) return false;
//			}
//		}
//		return true;
//	}

	public static void main(String[] args) {
		CountPrimes primes = new CountPrimes();
		System.out.println("Expected 4 found --> " + primes.countPrimes(10));
	}

}
