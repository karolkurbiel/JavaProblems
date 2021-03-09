package com.karolkurbiel.interviewproblems.besttimetobuyandsell;

public class FirstAttempt {

    /**
     * Problem:
     *      You are given an array prices where prices[i] is the price of a given stock on the ith day.
     *      Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy
     *      one and sell one share of the stock multiple times).
     *      You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
     *
     * source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * solved: 08/03/2021
     */

    public static void main(String[] args) {
        System.out.println(Solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(Solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(Solution.maxProfit(new int[]{7,6,4,3,1}));
    }

    private static class Solution {

        private static int maxProfit(int[] prices) {
            if(prices.length == 1) {
                return 0;
            }

            int wallet = 0;
            int currentPrice;
            int payedPrice = 0;
            boolean buyLock = false;

            for(int i = 0; i < prices.length; i++) {
                currentPrice = prices[i];

                //buying
                if(i == 0 && prices[i+1] > currentPrice && !buyLock) {
                    wallet -= currentPrice;
                    payedPrice = currentPrice;
                    buyLock = true;
                    continue;
                } else if(i != 0 && i < prices.length-1 && prices[i-1] >= currentPrice && prices[i+1] > currentPrice && !buyLock) {
                    wallet -= currentPrice;
                    payedPrice = currentPrice;
                    buyLock = true;
                    continue;
                }

                //selling
                if(buyLock) {
                    for(int j = i; j < prices.length; j++) {
                        currentPrice = prices[j];

                        if(j < prices.length-1 && currentPrice >= payedPrice && prices[j+1] < currentPrice) {
                            wallet += currentPrice;
                            payedPrice = 0;
                            buyLock = false;
                            i = j;
                            break;
                        } else if(j == prices.length-1 && currentPrice >= payedPrice) {
                            wallet += currentPrice;
                            payedPrice = 0;
                            buyLock = false;
                            i = j;
                            break;
                        }
                    }

                    if(buyLock) {
                        return 0;
                    }
                }
            }
            return wallet;
        }
    }
}
