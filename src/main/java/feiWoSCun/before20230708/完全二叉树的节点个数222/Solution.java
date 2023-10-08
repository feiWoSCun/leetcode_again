package feiWoSCun.before20230708.完全二叉树的节点个数222;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/24
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = Util.transArrToLinkedList
                (Arrays.asList
                        (1, 2, 3, 4, 5, 6));
        int i = new Solution().countNodes2(treeNode);
        System.out.println(i);
    }

    /**
     * 递归，深度优先
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @return
     */
    public int countNodes1(TreeNode root) {
        int res = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            if (poll != null) {
                if (poll.left != null) {
                    list.add(poll.left);
                }
                if (poll.right != null) {
                    list.add(poll.right);
                }
                res += 1;
            }
        }
        return res;
    }

    /**
     * 根据完全二叉树的特性,看了leetcode的详解 是log(n^2)的时间复杂度
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //层数
        int layers = 0;
        TreeNode t = root;
        //找到最后一层
        while ((t = t.left) != null) {
            layers += 1;
        }
        //计算区间,
        int low = (1 << layers);
        int high = (1 << (layers + 1)) - 1;
        //开始二分。注意是两边都是闭区间
        int middle = 0;
        int ans = -1;
        while (low <= high) {
            middle = low + (high - low) / 2;
            if (ifExist(root, layers, middle)) {
                //很重要的，这里不是找到符合条件就返回，而是最右边匹配
                ans = middle;
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return ans;
    }

    private boolean ifExist(TreeNode root, int level, int number) {
        TreeNode node = root;
        int judge = 1 << (level - 1);
        while (judge > 0 && node != null) {
            if ((number & judge) > 0) {
                node = node.right;
            } else {

                node = node.left;
            }

            judge >>= 1;
        }
        return node != null;
    }

}