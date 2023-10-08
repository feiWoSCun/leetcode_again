package feiWoSCun.after20230708.nk.JZ86在二叉树中找到两个节点的最近公共祖先;

import feiWoSCun.TreeNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/3
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (root==null) {
            return -1;
        }
        return postOrder(root, o1, o2).val;
    }

    public TreeNode postOrder(TreeNode node, int o1, int o2) {
        if (node == null) {
            return node;
        }
        if (node.val == o1 || node.val == o2) {
            return node;
        }
        TreeNode left = postOrder(node.left, o1, o2);
        TreeNode right = postOrder(node.right, o1, o2);
        if (left == null) {
            if (right != null) {
                return right;
            }
        }
        if (right == null) {
            return left;
        } else {
            return node;
        }

    }

    /**
     * 就是说有三种情况，一是left是root，二是right是root，三是他们自己都不是root，父是root
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor1(TreeNode root, int o1, int o2) {
        return CommonAncestor(root, o1, o2).val;
    }

    public TreeNode CommonAncestor(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) { // 如果root为空，或者root为o1、o2中的一个，则它们的最近公共祖先就为root
            return root;
        }
        TreeNode left = CommonAncestor(root.left, o1, o2);    // 递归遍历左子树，只要在左子树中找到了o1或o2，则先找到谁就返回谁
        TreeNode right = CommonAncestor(root.right, o1, o2);  // 递归遍历右子树，只要在右子树中找到了o1或o2，则先找到谁就返回谁
        if (left == null) {  // 如果在左子树中o1和o2都找不到，则o1和o2一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
            return right;
        } else if (right == null) { // 否则，如果left不为空，在左子树中有找到节点（o1或o2），这时候要再判断一下右子树中的情况，
            // 如果在右子树中，o1和o2都找不到，则 o1和o2一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
            return left;
        } else {
            return root; // 否则，当 left和 right均不为空时，说明 o1、o2节点分别在 root异侧, 最近公共祖先即为 root
        }
    }
}
