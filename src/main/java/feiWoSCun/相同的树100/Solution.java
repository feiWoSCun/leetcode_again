package feiWoSCun.相同的树100;


/**
 * @author: feiWoSCun
 * @Time: 2023/2/17
 * @Email: 2825097536@qq.com
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
   if (p == null) {
            return q == null;
        } else if (q == null) {
            return p == null;
        }
        else if(q.val!=p.val){
            return false
            ;
        }
        else {
        } return  isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
    }


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
