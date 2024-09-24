package com.practice.arrays;

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
