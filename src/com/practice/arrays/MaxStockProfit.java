package com.practice.arrays;
/**
 * Problem Statement:
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.



Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

 * @author Tata Rao Karri
 *
 */
public class MaxStockProfit {

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		
		int maxProfit = solution.maxProfit(new int[] {7,1,5,3,6,4});
		System.out.println(maxProfit);
		maxProfit = solution.maxProfit(new int[] {1,2,3,4,5});
		System.out.println(maxProfit);
		maxProfit = solution.maxProfit(new int[] {7,6,4,3,1});
		System.out.println(maxProfit);

	}

}
class Solution1 {
	//Max profit gain in buying and selling - 2 pointer solution  
    public int maxProfit(int[] prices) {
    	if(prices.length<2)
    		return 0;
        int i=0;
        int j=1;
        int sum = 0;
        int currentprofit = 0;
        while(j<prices.length){
            if(prices[j]-prices[i]>currentprofit) {
            	currentprofit = prices[j]-prices[i];
            }else {
            	sum += currentprofit;
            	currentprofit = 0;
            	i = j;
            }
            j++;
        }
        if(currentprofit>0) {
        	sum += currentprofit;
        }
        return sum;
    }
}
