package com.karolkurbiel.variousproblems.runningsum;

import java.util.Arrays;

public class RunningSum {

    /**
     * source: https://leetcode.com/problems/running-sum-of-1d-array/
     * solved: 04/03/2021
     */

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3 , 4};
        System.out.println(Arrays.toString(Solution.runningSum(input)));
    }

    private static class Solution {
        public static int[] runningSum(int[] nums) {

            int[] returnArray = new int[nums.length];

            for(int i = 0; i < nums.length; i++) {
                returnArray[i] = sumMaker(i, nums);
            }

            return returnArray;
        }

        public static int sumMaker(int i, int[] nums) {
            if(i == 0) {
                return nums[i];
            }
            return nums[i]+sumMaker(i-1, nums);
        }
    }
}
