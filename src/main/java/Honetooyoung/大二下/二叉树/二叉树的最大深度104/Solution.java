package Honetooyoung.大二下.二叉树.二叉树的最大深度104;

import Honetooyoung.大二下.common.TreeNode;
import Honetooyoung.大二下.common.TreeNodeUtil;

import java.util.ArrayList;

class Solution {
    //牛笔的方法
    public int maxDepth2(TreeNode root){
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    int ans=1;
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        search(root,1);
        return ans;
    }

    private void search(TreeNode node,int layer) {
        if (node!=null){
            ans= Math.max(layer, ans);
            search(node.left,layer+1);
            search(node.right,layer+1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.trans(new Integer[]{});
        System.out.println(new Solution().maxDepth(root));
    }
}