package com.karolkurbiel.variousproblems.biggestarrayinmatrix;

public class TheBiggestArray {

    /**
     * Problem:
     *      You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i^th customer
     *      has in the j^th bank. Return the wealth that the richest customer has.
     *      A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is
     *      the customer that has the maximum wealth.
     *
     * source: https://leetcode.com/problems/richest-customer-wealth/
     * solved: 05/03/2021
     */

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,1,2,2};
        int[] arr2 = new int[]{2,4,2,1};
        int[] arr3 = new int[]{1,1,1,1};
        int[] arr4 = new int[]{1,1,0,0};
        int[] arr5 = new int[]{8,6,7,2};
        int[] arr6 = new int[]{9,8,3,6};
        int[][] input = new int[][]{arr1, arr2, arr3, arr4, arr5, arr6};
        System.out.println(Solution.maximumWealth(input));
    }

    private static class Solution {
        private static int maximumWealth(int[][] accounts) {
            int theBiggestNumber = Integer.MIN_VALUE;
            int arraySum;

            for(int[] singleArray : accounts) {
                arraySum = getArraySum(singleArray);
                if(theBiggestNumber < arraySum) {
                    theBiggestNumber = arraySum;
                }
            }

            return theBiggestNumber;
        }

        private static int getArraySum(int[] inputArray) {
            int sum = 0;
            for(int element : inputArray) {
                sum += element;
            }
            return sum;
        }
    }
}
