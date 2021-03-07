package com.karolkurbiel.interviewproblems.validanagram;

import java.util.Arrays;

public class FirstAttempt {

    /**
     * Problem:
     *      Given two strings s and t , write a function to determine if t is an anagram of s.
     *
     * source: https://leetcode.com/problems/valid-anagram/
     * solved: 07/03/2021
     */

    public static void main(String[] args) {
        System.out.println(Solution.isAnagram("aaffhh", "hfafah"));
    }

    private static class Solution {
        private static boolean isAnagram(String s, String t) {
            //solution 1:
//         List<Character> firstWord = new ArrayList<>();
//         List<Character> secondWord = new ArrayList<>();

//         for(int i = 0; i < s.length(); i++) {
//             firstWord.add(s.charAt(i));
//         }
//         for(int i = 0; i < t.length(); i++) {
//             secondWord.add(t.charAt(i));
//         }

//         Collections.sort(firstWord);
//         Collections.sort(secondWord);

//         return firstWord.equals(secondWord);

            //solution 2:
//         if(s.length() != t.length()) {
//             return false;
//         }

//         char[] firstWord = s.toCharArray();
//         char[] secondWord = t.toCharArray();
//         boolean flag;
//         char checkedChar;

//         for(int i = 0; i < firstWord.length; i++) {

//             flag = false;
//             checkedChar = firstWord[i];

//             for(int j= 0; j < secondWord.length; j++) {
//                 if(checkedChar == secondWord[j]) {
//                     secondWord[j] = 0;
//                     flag = true;
//                     break;
//                 }
//             }

//             if(!flag) {
//                 return false;
//             }
//         }
//         return true;

            //solution 3:
            if(s.length() != t.length()) {
                return false;
            }
            char[] firstWord = s.toCharArray();
            char[] secondWord = t.toCharArray();
            Arrays.sort(firstWord);
            Arrays.sort(secondWord);
            return Arrays.equals(firstWord, secondWord);
        }
    }
}
