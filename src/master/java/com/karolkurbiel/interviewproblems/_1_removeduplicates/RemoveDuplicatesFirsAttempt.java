package com.karolkurbiel.interviewproblems._1_removeduplicates;

import java.util.Arrays;

public class RemoveDuplicatesFirsAttempt {

    /**
     * Problem:
     *      Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
     *
     *      Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     *      Clarification:
     *
     *      Confused why the returned value is an integer but your answer is an array?
     *
     *      Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
     *
     * source: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     * solved: 22/04/2021
     */

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Solution.removeDuplicates(nums);
        System.out.println("sorted index" + Arrays.toString(nums));
    }

    private static class Solution {
        private static int removeDuplicates(int[] nums) {
            if(nums.length == 0) {
                return 0;
            }

            int i = 0;
            for(int j = 1; j < nums.length; j++) {

                if(nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i+1;
        }
    }
}
