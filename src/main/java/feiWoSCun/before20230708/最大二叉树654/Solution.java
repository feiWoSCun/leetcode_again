package feiWoSCun.before20230708.最大二叉树654;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: @link 从中序与后序遍历序列构造二叉树106.Solution
 * @author: feiWoSCun
 * @Time: 2023/6/2
 * @Email: 2825097536@qq.com
 */
public class Solution {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int arrays[];

    public static void main(String[] args) {


        TreeNode treeNode = Util.transferToTreenode(Arrays.asList(3, 2, 1, 6, 0, 5));
        TreeNode treeNode1 = new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode1);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        arrays = nums;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            hashMap.put(nums[i], i);
        }
        TreeNode node = constructMaximumBinaryTree1(left, right, max);
        return node;
    }

    private TreeNode constructMaximumBinaryTree1(int left, int right, int max) {
        if(left>right){
            return null;
        }
        Integer pos = hashMap.get(max);
        TreeNode treeNode = new TreeNode(max);
        treeNode.left = constructMaximumBinaryTree1(left, pos - 1, getMax(left, pos - 1, arrays));
        treeNode.right = constructMaximumBinaryTree1(pos + 1, right, getMax(pos + 1, right, arrays));
        return treeNode;
    }

    public int getMax(int left, int right, int nums[]) {
        int max = 0;
        while (right >= left) {
            int j = Math.max(nums[left], (nums[right]));
            max = Math.max(max, j);
            left += 1;
            right -= 1;
        }
        return max;
    }

}
