package com.bk;

/***
 * Leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 
Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.

 * @author bhaveshkumar.chaudhari@gmail.com
 *
 */
public class BuySellStockWithTrasactionFees {
	
	public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int low = Integer.MAX_VALUE;
        int high = 0;
        int maxProfit = 0;
        int totalProfit = 0;
        for(int i = 0; i < n; i++) {
        	if(prices[i] < low || (maxProfit > fee && (high - prices[i]) > fee)) {
        		low = prices[i];
        		high = 0;
        		if(maxProfit > fee)
        			totalProfit = totalProfit + maxProfit - fee;
        		maxProfit = 0;
        	} 
        	else if(prices[i] >= high && (prices[i] - low) > fee) {
        		high = prices[i];
        		maxProfit = Math.max((high - low), maxProfit);
        	}
        }
        if(maxProfit > fee)
        	totalProfit = totalProfit + maxProfit - fee;
        return totalProfit > 0 ? totalProfit: 0;
    }
	public static void main(String[] args) {
		int[] prices1 = {1, 3, 2, 8, 4, 9};
		int[] prices2 = {1,2,3,4,5};
		int[] prices3 = {7,6,4,3,1};
		int[] prices4 = {1,2,4,2,5,7,2,4,9,0};
		int[] prices5 = {3,3,5,0,0,3,1,4};
		int[] prices6 = {1,3,7,5,10,3};
		int fee = 2;
		
		BuySellStockWithTrasactionFees bs = new BuySellStockWithTrasactionFees();
		System.out.println("expected 8 Found --> " + bs.maxProfit(prices1, fee));
		System.out.println("expected 2 Found --> " + bs.maxProfit(prices2, fee));
		System.out.println("expected 0 Found --> " + bs.maxProfit(prices3, fee));
		System.out.println("expected 9 Found --> " + bs.maxProfit(prices4, fee));
		System.out.println("expected 2 Found --> " + bs.maxProfit(prices5, fee));
		System.out.println("expected 6 Found --> " + bs.maxProfit(prices6, 3));
	}

}
