package feiWoSCun.before20230708.对称二叉树101;

import feiWoSCun.TreeNode;

import java.util.LinkedList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/23
 * @Email: 2825097536@qq.com
 */
public class Solution {
    //1,2,2,null,3,null,3
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3);
        node.left = treeNode;
        node.right = treeNode1;
        treeNode.left = null;
        treeNode.right = treeNode2;
        treeNode1.left = null;
        treeNode.right = treeNode3;
        boolean symmetric = new Solution().isSymmetric(node);
        System.out.println(symmetric);
    }

    public boolean isSymmetric(TreeNode root) {
        //Executors.newCachedThreadPool()
        //分成左右两边开始遍历
        LinkedList<TreeNode> left = new LinkedList<>();
        LinkedList<TreeNode> right = new LinkedList<>();
        left.add(root.left);
        right.add(root.right);
        //遍历结束条件
        while (!left.isEmpty() || !right.isEmpty()) {
            //从左右节点取出
            TreeNode a = left.poll();
            TreeNode b = right.poll();
            if (a ==null&&null== b) {
                continue;
            } else if (a==null||b==null) {
                return false;
            } else if (a.val == b.val) {
                //如果元素一致，就继续添加孩子
                left.add(a.left);
                left.add(a.right);
                right.add(b.right);
                right.add(b.left);
            } else {
                return false;
            }
        }
        //遍历结束，返回成功
        return true;
    }

}
