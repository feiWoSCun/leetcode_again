package feiWoSCun.after2024.hot102;

/*
  @description:
 * @author: feiWoSCun
 * @Time: 2024/3/7
 * @Email: 2825097536@qq.com
 */

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = Util.transferToTreenode(Arrays.asList(3, 9, 20, null, null, 15, 7));
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        System.out.println(lists);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> pre = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pre.offer(root);
        while (!pre.isEmpty()) {
            List<Integer> inres = new ArrayList<>();
            while (!pre.isEmpty()) {
                TreeNode temp = pre.poll();
                inres.add(temp.val);
                if (root.left != null) {
                    next.offer(root.left);
                }
                if (root.right != null) {
                    next.offer(root.right);
                }
            }
            res.add(inres);
            pre = next;
            next = new LinkedList<>();
        }
        return res;
    }

}
