package com.karolkurbiel.interviewproblems.validparentheses;

import java.util.*;

public class FirstAttempt {

    /**
     * Problem:
     *      Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
     *      string is valid.
     *      An input string is valid if:
     *          - Open brackets must be closed by the same type of brackets.
     *          - Open brackets must be closed in the correct order.
     *
     * source: https://leetcode.com/problems/valid-parentheses/
     * solved: 17/03/2021
     */

    public static void main(String[] args) {
        String s = "(([{[]}]))(){[]}";
//        String s = "([])";
        System.out.println(Solution.isValid(s));
    }

    private static class Solution {
        private static boolean isValid(String s) {
            Map<Character, Character> mappings =  new HashMap<>();
            mappings.put(')', '(');
            mappings.put('}', '{');
            mappings.put(']', '[');

            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++) {
                char testedChar = s.charAt(i);

                // If the current character is a closing bracket.
                if (mappings.containsKey(testedChar)) {
                    // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                    char topElement = stack.empty() ? '#' : stack.pop();
                    // If the mapping for this bracket doesn't match the stack's top element, return false.
                    if (topElement != mappings.get(testedChar)) {
                        return false;
                    }
                } else {
                    // If it was an opening bracket, push to the stack.
                    stack.push(testedChar);
                }
            }

            // If the stack still contains elements, then it is an invalid expression.
            return stack.isEmpty();
        }
    }
}
