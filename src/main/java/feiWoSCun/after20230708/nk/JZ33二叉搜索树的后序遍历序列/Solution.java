package feiWoSCun.after20230708.nk.JZ33二叉搜索树的后序遍历序列;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/8/23
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        return VerifySquenceOfBST1(sequence, 0, sequence.length - 1);

    }

    public boolean VerifySquenceOfBST1(int nums[], int left, int right) {
        if (left >= right) {
            return true;
        }
        int r = right - 1;
        int temp = nums[right];
        while (nums[r] > temp) {
            r--;
        }
        while (left < right) {
            if (nums[left++] > nums[right]) {
                return false;
            }
        }
        return VerifySquenceOfBST1(nums, 0, r) && VerifySquenceOfBST1(nums, r + 1, right - 1);

    }
}