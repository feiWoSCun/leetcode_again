package feiWoSCun.after20230708.leetcode.二叉树最大宽度;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: copy 宫水三叶
 * @author: feiWoSCun
 * @Time: 2023/11/15
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = Util.transferToTreenode(Arrays.asList(1, 3, 2, 5, 3, null, 9));
        int i = new Solution().widthOfBinaryTree(treeNode);
        System.out.println(i);
    }
    Map<Integer, Integer> map = new HashMap<>();
    int ans;
    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return ans;
    }
    void dfs(TreeNode root, int u, int depth) {
        if (root == null) {
            return ;
        }
        //记录的是每个深度最左边的num
        if (!map.containsKey(depth)) {
            map.put(depth, u);
        }
        u = u - map.get(depth) + 1;
        ans = Math.max(ans, u);
        dfs(root.left, u << 1, depth + 1);
        dfs(root.right, (u << 1 )| 1, depth + 1);
    }
}
