package com.karolkurbiel.variousproblems.greatestnumberinarray;

import java.util.ArrayList;
import java.util.List;

public class GreatestNumber {
    /**
     * Problem:
     *      Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that
     *      the ith kid has.
     *      For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have
     *      the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
     *
     * source: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
     * solved: 05/03/2021
     */

    public static void main(String[] args) {
        int[] input = new int[]{10, 1, 5, 12, 16, 16, 1};
        int addedNumber = 8;
        System.out.println(Solution.kidsWithCandies(input, addedNumber));
    }

    private static class Solution {
        private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

            int theBiggest = getBiggestNumber(candies);
            List<Boolean> returnList = new ArrayList<>();

            for (int candy : candies) {
                if (candy + extraCandies >= theBiggest) {
                    returnList.add(true);
                } else {
                    returnList.add(false);
                }
            }

            return returnList;
        }

        private static int getBiggestNumber(int[] space) {
            int biggest = space[0];
            for(int number : space) {
                if(biggest < number) {
                    biggest= number;
                }
            }
            return biggest;
        }
    }
}
