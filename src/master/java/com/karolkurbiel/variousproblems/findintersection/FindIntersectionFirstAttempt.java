package com.karolkurbiel.variousproblems.findintersection;

import java.util.Arrays;
import java.util.TreeSet;

import static java.util.stream.Collectors.toCollection;

public class FindIntersectionFirstAttempt {

    /**
     * Problem:
     *      Have the function FindIntersection(strArr) read the array of strings stored in strArr which will contain 2 elements:
     *      the first element will represent a list of comma-separated numbers sorted in ascending order,
     *      the second element will represent a second list of comma-separated numbers (also sorted).
     *      Your goal is to return a comma-separated string containing the numbers that occur in elements of strArr in sorted order.
     *      If there is no intersection, return the string false.
     *
     * source: https://coderbyte.com/editor/Find%20Intersection:Java
     * solved: 06/05/2021
     */

    public static void main(String[] args) {
        String[] testArray = {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
        System.out.println(Solution.FindIntersection(testArray));
    }

    private static class Solution {
        public static String FindIntersection(String[] strArr) {
            if(strArr == null || strArr.length < 2) {
                return "false";
            }

            String[] firstList = strArr[0].split(", ");
            String[] secondList = strArr[1].split(", ");
            int firstNumber;
            int secondNumber;
            String returnString = "";

            for(String firstStringNumber : firstList) {
                firstNumber = Integer.parseInt(firstStringNumber);
                for(String secondStringNumber : secondList) {
                    secondNumber = Integer.parseInt(secondStringNumber);

                    if(firstNumber == secondNumber) {
                        returnString = addToString(returnString, firstStringNumber);
                        break;
                    }
                }
            }

            if(returnString.isBlank()) {
                return "false";
            } else {
                return returnString;
            }
        }

        public static String addToString(String returnString, String valueToAdd) {
            if(returnString.length() == 0 || returnString.isBlank()) {
                return valueToAdd;
            } else {
                return returnString + "," + valueToAdd;
            }
        }
    }

    private static class SolutionDos {
        public static String FindIntersection(String[] strArr) {
            TreeSet<Integer> set1 = Arrays.stream(strArr[0].replace(" ", "").split(",")).map(Integer::parseInt).collect(toCollection(TreeSet::new));
            TreeSet<Integer> set2 = Arrays.stream(strArr[1].replace(" ", "").split(",")).map(Integer::parseInt).collect(toCollection(TreeSet::new));
            set1.retainAll(set2);

            return (set1.isEmpty() ? "false" : Arrays.toString(new TreeSet<>(set1).toArray()).replace("]", "").replace("[", "").replace(" ", ""));
        }
    }
}
