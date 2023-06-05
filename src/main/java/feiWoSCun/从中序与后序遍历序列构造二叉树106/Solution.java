package feiWoSCun.从中序与后序遍历序列构造二叉树106;
import feiWoSCun.TreeNode;

import java.util.HashMap;

/**
 * @description: 给定两个整数数组 inorder 和 postorder ，其中 inorder
 * 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * @author: feiWoSCun
 * @Time: 2023/6/1
 * @Email: 2825097536@qq.com
 */
public class Solution {

    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    /**
     *
     * @param inorder 中序遍历
     * @param postorder 后序遍历
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //根据元素找到数组下标
        for(int i = 0;i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    /**
     *
     * @param is 中序的前指针
     * @param ie 中序的后指针
     * @param ps 后续的前指针
     * @param pe 后续的后指针
     * @return
     */
    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) {
            return null;
        }
        //找到根节点
        int root = post[pe];
        //找到中序遍历的根节点对应的数组下标
        int ri = memo.get(root);
        TreeNode node = new TreeNode(root);
        //精髓 1：为node左右赋值，2：理清楚这四个数值的关系
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        //保存的都是这一层递归的node
        return node;
    }
}

