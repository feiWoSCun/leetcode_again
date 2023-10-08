package feiWoSCun.after20230708.nk.JZ78把二叉树打印成多行;

import feiWoSCun.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/3
 * @Email: 2825097536@qq.com
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // write code here
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> pre = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        pre.addFirst(pRoot);
        while (!pre.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (!pre.isEmpty()) {
                TreeNode node = pre.pollFirst();
                temp.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            res.add(temp);
            //swap
            LinkedList<TreeNode> pre1 = pre;
            pre = next;
            next = pre1;
        }
        return res;
    }
}