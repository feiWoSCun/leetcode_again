package feiWoSCun.after20230708.nk.JZ27二叉树的镜像;

import feiWoSCun.TreeNode;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/21
 * @Email: 2825097536@qq.com
 */
public class Solution {

        public TreeNode Mirror(TreeNode pRoot) {
            if (pRoot == null) {
                return null;
            }
            TreeNode temp = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = temp;
            Mirror(pRoot.left);
            Mirror(pRoot.right);
            return pRoot;

            // write code here
        }

}
