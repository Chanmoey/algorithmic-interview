package com.moon.algorithmicinterview.dp.no11;

import com.moon.algorithmicinterview.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 337. House Robber III
 * // 考虑从r开始偷取
 * f(r) = max{f(r.left) + f(r.right);
 * r.var + f(r.left.left) + f(r.left.right) + f(r.right.left) + f(r.right.right)}
 */
class Solution {

    private HashMap<TreeNode, Integer> memo;
    private final List<TreeNode> list = new ArrayList<>();

    public int rob(TreeNode root) {
        this.memo = new HashMap<>();
        return search(root);
    }

    public int search(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (this.memo.containsKey(root)) {
            return this.memo.get(root);
        }

        int res = 0;
        if (root.left != null) {
            res += search(root.left.left) + search(root.left.right);
        }
        if (root.right != null) {
            res += search(root.right.left) + search(root.right.right);
        }

        res = Math.max(res + root.val, search(root.left) + search(root.right));
        this.memo.put(root, res);
        return res;
    }
}
