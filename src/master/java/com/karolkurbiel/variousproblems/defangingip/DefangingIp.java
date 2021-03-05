package com.karolkurbiel.variousproblems.defangingip;

public class DefangingIp {

    /**
     * source: https://leetcode.com/problems/defanging-an-ip-address/
     * solved: 04/03/2021
     */

    public static void main(String[] args) {
        String testCase = "127.0.0.1";
        System.out.println(Solution.defangIPaddr(testCase));
    }

    private static class Solution {
        public static String defangIPaddr(String address) {

            StringBuilder output = new StringBuilder();
            char ch;

            for(int i = 0; i < address.length(); i++) {

                ch = address.charAt(i);
                if(ch == '.') {
                    output.append("[.]");
                } else {
                    output.append(ch);
                }
            }

            return output.toString();
        }
    }
}
