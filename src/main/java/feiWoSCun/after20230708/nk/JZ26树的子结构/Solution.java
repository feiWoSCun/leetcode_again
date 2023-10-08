package feiWoSCun.after20230708.nk.JZ26树的子结构;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/19
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode node = Util.transArrToLinkedList(Arrays.asList(1, 2, 3));
        TreeNode node1 = Util.transArrToLinkedList(Arrays.asList(2, 3, null));
        boolean b = new Solution().HasSubtree(node, node1);
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;

        }
        if (root1 == null) {
            return false;
        }
        boolean judge = judge(root1, root2);
        if (judge) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean judge(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root1 != null && root2 == null) {
            return true;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return judge(root1.left, root2.left) && judge(root1.right, root2.right);

    }

}
