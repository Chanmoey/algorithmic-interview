package com.moon.algorithmicinterview.tree.no2;

import com.moon.algorithmicinterview.utils.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * @author Chanmoey
 * @date 2023/9/1
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null) {
            return 1 + minDepth(root.right);
        } else if (root.right == null) {
            return 1 + minDepth(root.left);
        } else {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
