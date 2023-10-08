package feiWoSCun.after20230708.nk.JZ77按之字形顺序打印二叉树;

import com.sun.source.tree.Tree;
import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.*;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/6
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {


        Solution s = new Solution();

        TreeNode node = Util.transArrToLinkedList(Arrays.asList(8, 6, 10, 5, 7, 9, 11));
        ArrayList<ArrayList<Integer>> print = s.Print(node);
        System.out.println(print);
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }

        LinkedList<TreeNode> first = new LinkedList<>();
        LinkedList<TreeNode> second = new LinkedList<>();
        first.add(pRoot);
        int turn = 2;

        while (first.size() != 0 || second.size() != 0) {
            ArrayList<Integer> nodeRes = new ArrayList<>();
            while (!first.isEmpty()) {

                if (turn % 2 == 0) {
                    Collections.reverse(first);
                    TreeNode nodeTemp = first.peek();
                    nodeRes.add(nodeTemp.val);
                    TreeNode node = first.poll();
                    if (node.right != null) {
                        second.add(node.right);
                    }
                    if (node.left != null) {
                        second.add(node.left);
                    }

                } else {

                    TreeNode node = first.pollLast();
                    nodeRes.add(node.val);
                    if (node.left != null) {
                        second.add(node.left);
                    }
                    if (node.right != null) {
                        second.add(node.right);
                    }
                }
            }
            LinkedList<TreeNode> temp = first;
            first = second;
            second = temp;
            if (turn % 2 != 0) {
                Stack<Integer> stack = new Stack<>();
                for (Integer nodeRe : nodeRes) {
                    stack.push(nodeRe);
                }
                ArrayList<Integer> integers = new ArrayList<>();
                while (!stack.isEmpty()) {
                    integers.add(stack.pop());
                }
                nodeRes = integers;
            }
            res.add(nodeRes);
            turn++;
        }
        return res;
    }


    /**
     * 题目：Z字形打印二叉树
     *
     * 思路:
     * 借助两个栈stack1,stack2.
     * 先让首节点接入stack1，然后奇数行时stack1中节点的孩子出队列加入stack2（按先左孩子再右孩子的顺序），并加入链中
     * 偶数行时出stack2中节点的孩子加入stack1(按先右孩子后左孩子的顺序)，并加入链
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> zTreeList = new ArrayList<>();
        if (pRoot == null) {
            return zTreeList;
        }
        Stack<TreeNode> oddStack = new Stack<>();//奇数行栈
        Stack<TreeNode> evenStack = new Stack<>();//偶数行栈
        boolean isOdd = true;
        oddStack.add(pRoot);
        while (!(oddStack.isEmpty() && evenStack.isEmpty())) {//树没有遍历完
            ArrayList<Integer> currentList = new ArrayList<>();
            if (isOdd == true) {//奇数行，stack1中节点的孩子节点按先左孩子后右孩子的顺序入栈2
                while (!oddStack.isEmpty()) {
                    TreeNode currentNode = oddStack.peek(); //取队栈顶元素
                    currentList.add(currentNode.val); //添加当前列表
                    if (currentNode.left != null) {
                        evenStack.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        evenStack.push(currentNode.right);
                    }
                    oddStack.pop(); //栈顶元素出栈
                }
                zTreeList.add(currentList);//加入当前行
                isOdd = false; //更新下一层扫描树为偶数行
            } else {//偶数行,stack2中元素节点的孩子按先右孩子孩子后左孩子顺序入stack1
                while (!evenStack.isEmpty()) {
                    TreeNode currentNode = evenStack.peek(); //获取栈顶元素
                    currentList.add(currentNode.val);
                    if (currentNode.right != null) {
                        oddStack.add(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        oddStack.add(currentNode.left);
                    }
                    evenStack.pop();
                }
                zTreeList.add(currentList);
                isOdd = true;
            }
        }
        return zTreeList;
    }
}
