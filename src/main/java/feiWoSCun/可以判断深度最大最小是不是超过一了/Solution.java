package feiWoSCun.可以判断深度最大最小是不是超过一了;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description: 判断二叉树深度最大最小是不是超过一了
 * @author: feiWoSCun
 * @Time: 2023/5/26
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = Util.transArrToLinkedList(Arrays.asList(3,9,20,22,23,15,7,9,7,6,4,4,null,null,null,2));
        boolean balanced = new Solution().isBalanced(treeNode);
        System.out.println(balanced);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //先找到首次出现null节点是在哪一排
        LinkedList<TreeNode> thisLine = new LinkedList<>();
        thisLine.add(root);
        LinkedList<TreeNode> nextLine = new LinkedList<>();
        LinkedList<TreeNode> temp = null;
        boolean ifBreak = false;
        int firstNull = -1;
        int NextNull = 0;
        nextLine.add(root);
        while (!nextLine.isEmpty()) {
            nextLine.clear();
            while (!thisLine.isEmpty()) {
                TreeNode first = thisLine.poll();
                TreeNode right = first.right;
                TreeNode left = first.left;

                if (right != null) {
                    nextLine.add(right);
                }
                if (left != null) {
                    nextLine.add(left);
                }
                if (firstNull == 0 && (right != null || left != null)) {
                    NextNull += 1;
                    if (NextNull == 2) {
                        return false;
                    }
                }
                if (right == null || left == null) {
                    firstNull = 0;
                }
            }
            //交换
            thisLine.clear();
            for (TreeNode treeNode : nextLine) {
                thisLine.add(treeNode);
            }
            ;
        }
        return true;
    }
}
