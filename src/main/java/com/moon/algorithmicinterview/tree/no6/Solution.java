package com.moon.algorithmicinterview.tree.no6;

import com.moon.algorithmicinterview.utils.TreeNode;

import java.util.Map;

/**
 * 110. Balanced Binary Tree
 *
 * @author Chanmoey
 * @date 2023/9/2
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(treeHigh(root.left) - treeHigh(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int treeHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeHigh(root.left), treeHigh(root.right)) + 1;
    }
}
