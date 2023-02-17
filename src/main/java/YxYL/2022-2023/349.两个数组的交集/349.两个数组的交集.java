import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 * 
 * 给定两个数组 nums1 和 nums2,
 * 返回它们的交集。输出结果中的每个元素一定是唯一的。我们可以不考虑输出结果的顺序。
        示例 1：
        输入：nums1 = [1,2,2,1], nums2 = [2,2]
        输出：[2]

        示例 2：
        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        输出：[9,4]
        解释：[4,9] 也是可通过的
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        HashSet<Integer> res = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }

        Object[] array = res.toArray();
        int[] ans = new int[array.length];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = Integer.parseInt(array[i].toString());
        }
        return ans;
    }
}
// @lc code=end
