package Honetooyoung.大二下.二叉树.统计二叉树中好节点的数目1448;

import Honetooyoung.大二下.common.TreeNode;

public class Solution {
    int ans=0;
    public int goodNodes(TreeNode root) {
        if (root!=null){
            dfs(root,Integer.MIN_VALUE);
        }
    return ans;
    }

    private void dfs(TreeNode root, int max) {
        if (root.val>=max){
            max=root.val;
            ans++;
        }
        if (root.left!=null)
            dfs(root.left,max);
        if (root.right!=null)
            dfs(root.right,max);
    }
}
