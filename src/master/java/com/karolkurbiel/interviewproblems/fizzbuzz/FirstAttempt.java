package com.karolkurbiel.interviewproblems.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FirstAttempt {

    /**
     * Problem:
     *      Write a program that outputs the string representation of numbers from 1 to n.
     *      But for multiples of three it should output “Fizz” instead of the number and for the multiples of five
     *      output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
     *
     * source: https://leetcode.com/problems/fizz-buzz/
     * solved: 06/03/2021
     */

    public static void main(String[] args) {
        System.out.println(Solution.fizzBuzz(15));
    }

    private static class Solution {
        private static List<String> fizzBuzz(int n) {
            List<String> outputList = new ArrayList<>();
            for(int i = 1; i <= n; i++) {
                if(i%3 == 0 && i%5 == 0) {
                    outputList.add("FizzBuzz");
                } else if(i%3 == 0) {
                    outputList.add("Fizz");
                } else if(i%5 == 0) {
                    outputList.add("Buzz");
                } else {
                    outputList.add("" + i);
                }
            }
            return outputList;
        }
    }
}
