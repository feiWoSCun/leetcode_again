package feiWoSCun.after20230708.nk.JZ77按之字形顺序打印二叉树;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/17
 * @Email: 2825097536@qq.com
 */
public class Solution2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> zTreeList = new ArrayList<>();
        if (pRoot == null) {
            return zTreeList;
        }
        Stack<TreeNode> singleStack = new Stack<>();//奇数行栈
        Stack<TreeNode> doubleStack = new Stack<>();//偶数行栈
        boolean isOdd = true;
        singleStack.add(pRoot);
        while (!(singleStack.isEmpty() && doubleStack.isEmpty())) {//树没有遍历完
            ArrayList<Integer> currentList = new ArrayList<>();
            if (isOdd == true) {//奇数行，stack1中节点的孩子节点按先左孩子后右孩子的顺序入栈2
                while (!singleStack.isEmpty()) {
                    TreeNode currentNode = singleStack.peek(); //取队栈顶元素
                    currentList.add(currentNode.val); //添加当前列表
                    if (currentNode.left != null) {
                        doubleStack.push(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        doubleStack.push(currentNode.right);
                    }
                    singleStack.pop(); //栈顶元素出栈
                }
                zTreeList.add(currentList);//加入当前行
                isOdd = false; //更新下一层扫描树为偶数行
            } else {//偶数行,stack2中元素节点的孩子按先右孩子孩子后左孩子顺序入stack1
                while (!doubleStack.isEmpty()) {
                    TreeNode currentNode = doubleStack.peek(); //获取栈顶元素
                    currentList.add(currentNode.val);
                    if (currentNode.right != null) {
                        singleStack.add(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        singleStack.add(currentNode.left);
                    }
                    doubleStack.pop();
                }
                zTreeList.add(currentList);
                isOdd = true;
            }
        }
        return zTreeList;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ArrayList<ArrayList<Integer>> arrayLists = solution2.Print1(Util.transferToTreenode(Arrays.asList(1, 2, 3, null, null, 4, 5)));
        System.out.println();
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> zTreeList = new ArrayList<>();
        if (pRoot == null) {
            return zTreeList;
        }
        Stack<TreeNode> singleStack = new Stack<>();
        Stack<TreeNode> doubleStack = new Stack<>();
        boolean ifSingle = true;
        singleStack.push(pRoot);
        while (!singleStack.isEmpty() || !doubleStack.isEmpty()) {
            ArrayList<Integer> res = new ArrayList<>();
            if (ifSingle) {
                while (!singleStack.isEmpty()) {
                    TreeNode pop = singleStack.pop();
                    res.add(pop.val);
                    Optional.ofNullable(pop.left).ifPresent(t -> doubleStack.push(pop.left));
                    Optional.ofNullable(pop.right).ifPresent(t -> doubleStack.push(pop.right));

                }
                ifSingle = false;
                zTreeList.add(res);
            } else {
                while (!doubleStack.isEmpty()) {
                    TreeNode pop = doubleStack.pop();
                    res.add(pop.val);
                    Optional.ofNullable(pop.right).ifPresent(t -> singleStack.push(pop.right));
                    Optional.ofNullable(pop.left).ifPresent(t -> singleStack.push(pop.left));
                }
                zTreeList.add(res);
                ifSingle = true;
            }
        }
        return zTreeList;
    }
}
