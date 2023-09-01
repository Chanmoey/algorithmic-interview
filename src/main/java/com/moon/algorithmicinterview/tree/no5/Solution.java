package com.moon.algorithmicinterview.tree.no5;

import com.moon.algorithmicinterview.utils.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 *
 * @author Chanmoey
 * @date 2023/9/2
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return this.countNodes(root.left) + this.countNodes(root.right) + 1;
    }
}