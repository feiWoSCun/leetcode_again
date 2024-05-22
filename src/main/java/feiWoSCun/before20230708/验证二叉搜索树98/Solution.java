package feiWoSCun.before20230708.验证二叉搜索树98;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/6/5
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = Util.transferToTreenode(Arrays.asList(5,1,4,null,null,3,6));
        boolean validBST = new Solution().isValidBST(treeNode);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {

        boolean validBST1 = isValidBST1(-1, root, 2, true, new ArrayList<>(16), new ArrayList<>(16));
        return validBST1;

    }

    /**
     * @param val     上一个递归的值
     * @param root
     * @param flag    true 右边
     * @param isValid true
     * @return
     */
    boolean isValidBST1(int val, TreeNode root, int flag, boolean isValid, List<Integer> left, List<Integer> right) {
        if (!isValid) {
            return false;
        }
        if (root == null) {
            return true;
        }
        if (root.val == val) {
            return false;
        }
        //右边
        if (root.val > val && flag != 0) {
            right.add(root.val);
            if ((isBig(left, root) != 2) && isBig(right, root) != 2) {
                isValid = true;
            } else {
                isValid = false;
            }
        }//左边
        if (flag != 1) {
            left.add(root.val);
            if (root.val < val) {
                if (isBig(right, root) != 2 && (isBig(left, root) <= 2)) {
                    isValid = true;
                } else {
                    isValid = false;
                }
            }
        }
        boolean validBST1 = isValidBST1(root.val, root.left, 0, isValid, left, right);
        if (flag == 0) {
            left.remove(left.size() - 1);
        }
        boolean validBST11 = isValidBST1(root.val, root.right, 1, isValid, left, right);
        if (flag == 1) {
            right.remove(right.size() - 1);
        }
        return validBST11 && validBST1;
    }

    /**
     * 1 相同，2：false 3；true
     *
     * @param tar
     * @param node
     * @return
     */
    private int isBig(List<Integer> tar, TreeNode node) {
        if (tar == null ||tar.size()<=2) {
            return 1;
        }
        int val = node.val;
        for (int i = 1; i < tar.size()-1 ; i++) {
            if (val <= tar.get(i)) {
                return 2;
            }
        }
        return 3;
    }
}
