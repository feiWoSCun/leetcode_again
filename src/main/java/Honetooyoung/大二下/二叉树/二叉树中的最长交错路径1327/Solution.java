package Honetooyoung.大二下.二叉树.二叉树中的最长交错路径1327;

import Honetooyoung.大二下.common.TreeNode;
import Honetooyoung.大二下.common.TreeNodeUtil;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.trans(new Integer[]{1,1,1,null,1,null,null,1,1,null,1});
        TreeNodeUtil.print(root);
        System.out.println(new Solution().longestZigZag(root));
    }
    int ans=0;
    public int longestZigZag(TreeNode root) {
        if (root==null)
            return ans;
        //true代表左，false代表右
        if(root.left!=null){
            ans++;
            dfs(root.left,false,1);
        }
        if(root.right!=null){
            ans=Math.max(ans,1);
            dfs(root.right,true,1);
        }
        return ans;
    }

    private void dfs(TreeNode root, boolean b, int len) {
        if (root.left!=null){
            if (b)
                ans=Math.max(ans,len+1);
            dfs(root.left,false,b?len+1:1);
        }
        if (root.right!=null){
            if (!b)
                ans=Math.max(ans,len+1);
            dfs(root.right,true,!b?len+1:1);
        }
    }
}
