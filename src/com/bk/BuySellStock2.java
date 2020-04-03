package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class BuySellStock2 {
	
	public int maxProfit(int[] prices) {
        int n = prices.length;
        int low = Integer.MAX_VALUE;
        int high = 0;
        int maxProfit = 0;
        int totalProfit = 0;
        for(int i = 0; i < n; i++) {
        	if((prices[i] < low) || (prices[i] >= low && prices[i] < high)) {
        		low = prices[i];
        		high = 0;
        		totalProfit = totalProfit + maxProfit;
        		maxProfit = 0;
        	}
        	else if(prices[i] >= high) {
        		high = prices[i];
        		maxProfit = Math.max((high - low), maxProfit);
        	}
        }
        totalProfit = totalProfit + maxProfit;
        return totalProfit;
    }
	public static void main(String[] args) {
		int[] prices1 = {7,1,5,3,6,4};
		int[] prices2 = {1,2,3,4,5};
		int[] prices3 = {7,6,4,3,1};
		int[] prices4 = {1,2,4,2,5,7,2,4,9,0};
		int[] prices5 = {3,3,5,0,0,3,1,4};
		
		BuySellStock2 bs = new BuySellStock2();
		System.out.println("expected 7 Found --> " + bs.maxProfit(prices1));
		System.out.println("expected 4 Found --> " + bs.maxProfit(prices2));
		System.out.println("expected 0 Found --> " + bs.maxProfit(prices3));
		System.out.println("expected 15 Found --> " + bs.maxProfit(prices4));
		System.out.println("expected 8 Found --> " + bs.maxProfit(prices5));
	}

}
