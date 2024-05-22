package feiWoSCun.before20230708.二叉树最大深度104;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/24
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8, null);
        TreeNode node = Util.transferToTreenode(list);
        int i = new Solution().maxDepth(node);
        System.out.println(i);
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = maxDepth(root.left);
        int j=maxDepth(root.right);
        return 1 + Math.max(i,j);
    }
}