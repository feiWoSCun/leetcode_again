package feiWoSCun.翻转二叉树226;
import feiWoSCun.TreeNode;
/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/21
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = root.right;
        root.right= root.left;
        root.left=right;
         invertTree(root.left);
         invertTree(root.right);
        return  root;
}
}
