package feiWoSCun.after20230708.nk.JZ84二叉树中和为某一值的路径;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/3
 * @Email: 2825097536@qq.com
 */
public class Solution {

    private int path;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = Util.transArrToLinkedList(Arrays.asList(1, 2, 3, 4, 5, 4, 3, null, null, -1));
        solution.FindPath(node,6);
    }
    public int FindPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            visit(t, sum);
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }
        return path;
    }


    private void visit(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        if (sum == 0) {
            path++;
        //不能return
        }
        visit(root.left, sum);
        visit(root.right, sum);
    }
}
