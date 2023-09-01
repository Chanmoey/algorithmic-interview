package com.moon.algorithmicinterview.tree.no3;

import com.moon.algorithmicinterview.utils.TreeNode;

/**
 * 226. Invert Binary Tree
 *
 * @author Chanmoey
 * @date 2023/9/1
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 翻转左右孩子
        root.left = right;
        root.right = left;
        return root;
    }
}