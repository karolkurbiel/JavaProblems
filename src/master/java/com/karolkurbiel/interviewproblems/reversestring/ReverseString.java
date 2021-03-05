package com.karolkurbiel.interviewproblems.reversestring;

public class ReverseString {

    /**
     * Problem:
     *      Write a function that reverses a string. The input string is given as an array of characters char[].
     *      Do not allocate extra space for another array, you must do this by modifying the input array in-place with
     *      O(1) extra memory.
     *      You may assume all the characters consist of printable ascii characters.
     *
     * source: https://leetcode.com/problems/reverse-string/
     * solved: 05/03/2021
     */

    public static void main(String[] args) {
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        Solution.reverseString(input);
        System.out.println(input);
    }

    private static class Solution {
        private static void reverseString(char[] s) {
            int arrayLength = s.length;
            char tempChar;

            for(int i = 0; i < arrayLength/2 ; i++) {
                tempChar = s[i];
                s[i] = s[arrayLength-1-i];
                s[arrayLength-1-i] = tempChar;
            }
        }
    }
}
