package feiWoSCun.合并两个有序数组88;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Description：懂的人自然懂
 * @Author: feiWoSCun
 * @Email: 2825097536@qq.com
 * @Date: 2022-1-24
 * 还可以用双指针 记得看一下
 * 时间 1ms 击败 31.72% 内存 41.7 M 击败 14.64%
 * */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i =m,j=0; i < m + n; i++,j++) {
            nums1[i]=nums2[j];
        }
        Arrays.sort(nums1);
    }
}
