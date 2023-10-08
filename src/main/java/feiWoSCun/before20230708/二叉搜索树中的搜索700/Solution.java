package feiWoSCun.before20230708.二叉搜索树中的搜索700;

import feiWoSCun.TreeNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/6/5
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else  {
            return searchBST(root.right, val);
        }

    }

}
