package feiWoSCun.before20230708.二叉树的迭代遍历;

import feiWoSCun.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/21
 * @Email: 2825097536@qq.com
 */
public class Solution1 {


    public List<Integer> preOrder(TreeNode root) {
        //申请一个List
   List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) {
            st.push(root);
        }
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                TreeNode pop = st.pop();
                if (node.right != null) {
                    st.push(node.right);
                }
                if (node.left != null) {
                    st.push(node.left);
                }
                st.push(node);
                st.push(null);
            } else {
                st.pop();
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
