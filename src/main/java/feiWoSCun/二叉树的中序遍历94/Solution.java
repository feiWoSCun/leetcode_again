package feiWoSCun.二叉树的中序遍历94;

import feiWoSCun.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/17
 * @Email: 2825097536@qq.com
 */
public class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return this.res;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        return inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(7);
        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(9);
        TreeNode treeNode9 = new TreeNode(10);


        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode3.left = treeNode7;
        treeNode7.left = treeNode8;
        treeNode7.right = treeNode9;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;
        List<Integer> integers = new Solution().inorderTraversal(treeNode);
        System.out.println(integers);
    }
}

