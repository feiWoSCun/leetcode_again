package feiWoSCun.after20230708.nk.JZ54二叉搜索树的第k个节点;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/18
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().KthNode(Util.transferToTreenode(Arrays.asList(5,3,7,2,4,6,8)),5);
    }
    private int j = 0;
    private int res = -1;

    public int KthNode(TreeNode proot, int k) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        int rank = 1;
        while (!stack.isEmpty() || proot != null) {
            while (proot != null) {
                stack.push(proot);
                proot = proot.left;
            }
            if (!stack.isEmpty()) {
                proot = stack.pop();
                System.out.println(proot.val);
                if (rank == k) {
                    return proot.val;
                } ;
                rank++;
                proot = proot.right;
            }
        }
        return -1;
    }
}
