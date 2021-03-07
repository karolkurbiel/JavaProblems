package com.karolkurbiel.interviewproblems.majorityelement;

import java.util.HashMap;
import java.util.Map;

public class FirstAttempt {

    /**
     * Problem:
     *      Given an array nums of size n, return the majority element.
     *      The majority element is the element that appears more than n / 2 times. You may assume that the majority
     *      element always exists in the array.
     *
     * source: https://leetcode.com/problems/majority-element/
     * solved: 07/03/2021
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3};
        System.out.println(Solution.majorityElement(nums));
    }

    private static class Solution {
        private static int majorityElement(int[] nums) {
            Map<Integer, Integer> numberDictionary = new HashMap<>();
            for(int number : nums) {
                numberDictionary.put(number, (numberDictionary.getOrDefault(number, 0) + 1));
            }

            int appearedNo = 0;
            int majorityNumber = 0;

            for(Map.Entry<Integer, Integer> mapEntry : numberDictionary.entrySet()) {
                if(mapEntry.getValue() > appearedNo) {
                    majorityNumber = mapEntry.getKey();
                    appearedNo = mapEntry.getValue();
                }
            }
            return majorityNumber;
        }
    }

    private static class CrazySolution {
        private static int majorityElement(int[] nums) {
            int count = 0;
            Integer candidate = null;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
    }
}
