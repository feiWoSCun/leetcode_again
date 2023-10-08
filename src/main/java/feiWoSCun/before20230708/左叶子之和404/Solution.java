package feiWoSCun.before20230708.左叶子之和404;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/30
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = Util.transArrToLinkedList(Arrays.asList(1, 2, 3, 4, 5));
        int i = new Solution().sumOfLeftLeaves(treeNode);
        System.out.println(i);
    }

    public int sumOfLeftLeaves(TreeNode root) {

        int res = getRes(root, 0);
        return res;
    }

    private int getRes(TreeNode root, int i) {
        if(root==null){
            return 0;
        }
        int j = 0;
        if (root.left == root.right) {
            if (i == 1) {
                j = root.val;
            } else {
                j = 0;
            }
        }
        return j + getRes(root.left, 1) + getRes(root.right, 0);

    }
}