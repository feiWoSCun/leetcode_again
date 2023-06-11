package Honetooyoung.大二下.二叉树.路径总和III437;

import Honetooyoung.大二下.common.TreeNode;
import Honetooyoung.大二下.common.TreeNodeUtil;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.trans(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        TreeNodeUtil.print(root);
        int i = new Solution().pathSum(root, 0);
        System.out.println(i);
    }
    int ans=0,tar;
    public int pathSum(TreeNode root, int targetSum) {
        tar=targetSum;
        if(root!=null){
            dfs(root);
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root.left!=null) dfs(root.left);
        if (root.right!=null) dfs(root.right);
        getSum(root,tar);
    }

    private void getSum(TreeNode root,int t) {
        int temp=t-root.val;
        if (temp==0) ans++;
        if (root.left!=null){
                getSum(root.left,temp);
        }
        if (root.right!=null){
                getSum(root.right,temp);
        }
    }
}
