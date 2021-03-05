package com.karolkurbiel.interviewproblems.maximumdepthofbonarytree;

public class MaximumDepthOfBinaryTree {

    /**
     * Problem:
     *      Given the root of a binary tree, return its maximum depth.
     *      A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * source: https://leetcode.com/problems/maximum-depth-of-binary-tree/
     * solved: 05/03/2021
     */

    public static void main(String[] args) {
    }

    private static class Solution {
        private static int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            int count = Math.max(maxDepth(root.left),maxDepth(root.right));
            return count+1;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
