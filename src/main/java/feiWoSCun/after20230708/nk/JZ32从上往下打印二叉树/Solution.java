package feiWoSCun.after20230708.nk.JZ32从上往下打印二叉树;

import com.sun.source.tree.Tree;
import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/23
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode node = Util.transArrToLinkedList(Arrays.asList(8, 6, 10, null, null, 2, 1));
        ArrayList<Integer> arrayList = new Solution().PrintFromTopToBottom(node);
        System.out.println(arrayList);

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();
        first.push(root);
        while (first.size() !=0|| second.size()!=0) {
            while (!first.isEmpty()) {
                TreeNode node = first.poll();
                res.add(node.val);
                if (node.left != null) {
                    second.add(node.left);
                }
                if (node.right != null) {
                    second.add(node.right);
                }
            }
            first = second;
            second = new LinkedList<TreeNode>();
        }
        return res;
    }
}
