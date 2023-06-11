package Honetooyoung.大二下.二叉树.叶子相似的树872;

import Honetooyoung.大二下.common.TreeNode;
import Honetooyoung.大二下.common.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;


public class Solution {
    ArrayList<Integer> temp1 = new ArrayList<>();
    ArrayList<Integer> temp2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1!=null){
            dfs(root1,temp1);
        }
        if(root2!=null){
            dfs(root2,temp2);
        }
        return temp1.equals(temp2);
    }

    private void dfs(TreeNode root, List<Integer> temp) {
       if (root.left!=null) dfs(root.left,temp);
       if (root.right!=null) dfs(root.right,temp);
       if (root.left==null&root.right==null) temp.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNodeUtil.trans(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        TreeNode root2 = TreeNodeUtil.trans(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        TreeNodeUtil.print(root1);
        TreeNodeUtil.print(root2);
        System.out.println(new Solution().leafSimilar(root1, root2));
    }
}
