package feiWoSCun.after20230708.leetcode.二叉树的最大深度;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/25
 * @Email: 2825097536@qq.com
 */

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.Stack;

/**
 *  [0,2,4,1,null,3,-1,5,1,null,6,null,8] 这个案例倒下了
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {

 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = Util.transferToTreenode(Arrays.asList(3, 9, 20, null, null, 15, 7));
        solution.maxDepth(treeNode);
    }
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int level=1;
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;
        int ans=0;
        while(node!=null||!st.isEmpty()){
            while(node!=null){
                st.push(node);
                node=node.left;
                level++;
            }
            //中序遍历
            TreeNode next=st.pop();
            level=(next.right==null)?level-1:level;
            ans=Math.max(ans,level);
            //往右走
            node=next.right;

        }
        return ans;
    }
}