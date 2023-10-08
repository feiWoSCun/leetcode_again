package feiWoSCun.after20230708.nk.JZ34二叉树中和为某一值的路径;

import feiWoSCun.ListNode;
import feiWoSCun.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/24
 * @Email: 2825097536@qq.com
 */
public class Solution {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    private LinkedList<Integer> nowList = new LinkedList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        // write code here
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        target -= root.val;
        nowList.addLast(root.val);
        if (root.left == root.right && target == 0) {
            res.add(new ArrayList<>(nowList));
            nowList.removeLast();
           //注意return
            return;
        }
        dfs(root.left, target);
        dfs(root.right, target);
        //注意
        nowList.removeLast();
    }
}
