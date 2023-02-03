import java.util.Stack;

import javax.crypto.NullCipher;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //说明同时为空并且之前的判断都是通过了的
        if (q == null && p == null)
            return true;
        //说明有一边没了，不通过
        if (q == null || p == null)
            return false;
        if (q.val != p.val)
            return false;
        //递归调用
        return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);

    }

}
// @lc code=end
