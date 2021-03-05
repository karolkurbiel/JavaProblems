package com.karolkurbiel.variousproblems.shuflearray;

import java.util.Arrays;

public class ShuffleArray {

    /**
     * Problem:
     *      Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
     *      Return the array in the form [x1,y1,x2,y2,...,xn,yn].
     *
     * source: https://leetcode.com/problems/shuffle-the-array/
     * solved: 05/03/2021
     */

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2};
        int n = 2;
        System.out.println(Arrays.toString(Solution.shuffle(nums, n)));
    }

    private static class Solution {
        private static int[] shuffle(int[] nums, int n) {
            int[] returnArray = new int[nums.length];
            int marker = 0;

            for(int i = 0; i < nums.length/2; i++) {
                returnArray[marker] = nums[i];
                marker++;
                returnArray[marker] = nums[n+i];
                marker++;
                n = Integer.MIN_VALUE;
            }
            return returnArray;
        }
    }
}
