package com.karolkurbiel.interviewproblems.uniquenumber;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumber {

    /**
     * Problem:
     *      Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * source: https://leetcode.com/problems/single-number/
     * solved: 05/03/2021
     */

    public static void main(String[] args) {
        int[] input = new int[]{1,1,2,2,69};
        System.out.println(Solution.singleNumber(input));
        System.out.println(WildSolution.singleNumber(input));
    }

    private static class Solution {
        private static int singleNumber(int[] nums) {
            Map<Integer, Integer> numberTable = new HashMap<>();

            for(int number : nums) {
                numberTable.put(number, (numberTable.getOrDefault(number, 0) +1));
            }
            for(Map.Entry<Integer, Integer> entry : numberTable.entrySet()) {
                if(entry.getValue() == 1) {
                    return entry.getKey();
                }
            }
            throw new IllegalArgumentException();

//            List<Integer> uniqueNumberList = new ArrayList<>();
//
//            for(int number : nums) {
//                if(!uniqueNumberList.contains(number)) {
//                    uniqueNumberList.add(number);
//                } else {
//                    uniqueNumberList.remove((Integer) number);
//                }
//            }
//            return uniqueNumberList.get(0);
        }
    }

    private static class WildSolution {
        private static int singleNumber(int[] nums) {
            int a = 0;
            for (int i : nums) {
                a ^= i;
            }
            return a;
        }
    }
}
