package feiWoSCun.路径总和112;

import com.sun.tools.javac.Main;
import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;

/**
 * @description: 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * @author: feiWoSCun
 * @Time: 2023/6/1
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = Util.transArrToLinkedList(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1));
        boolean b = new Solution().hasPathSum(treeNode, 22);
        System.out.println(b);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int nowSum = 0;
        boolean b = hasPath(root, targetSum, nowSum);
        return b;

    }

    private boolean hasPath(TreeNode root, int targetSum, int nowSum) {
        if (root == null) {
            return false;
        }
        if (root.left == root.right) {
            return targetSum == nowSum+ root.val ? true : false;
        }
        //这一排代码，需要注意的是，参数是nowSum+root.val而你不是nowSum+=root.val,这里面有个回溯的概念，这一层存的永远是上面层数的所有之和
        return hasPath(root.left, targetSum, nowSum + root.val) || hasPath(root.right, targetSum, nowSum + root.val);
    }
}
