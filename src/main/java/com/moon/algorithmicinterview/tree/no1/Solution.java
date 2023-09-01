package com.moon.algorithmicinterview.tree.no1;

import com.moon.algorithmicinterview.utils.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author Chanmoey
 * @date 2023/8/31
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
