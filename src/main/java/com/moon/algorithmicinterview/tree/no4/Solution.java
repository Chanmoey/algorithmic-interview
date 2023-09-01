package com.moon.algorithmicinterview.tree.no4;

import com.moon.algorithmicinterview.utils.TreeNode;

/**
 * 101. Symmetric Tree
 *
 * @author Chanmoey
 * @date 2023/9/1
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left != null && right != null && left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }

        return false;
    }
}