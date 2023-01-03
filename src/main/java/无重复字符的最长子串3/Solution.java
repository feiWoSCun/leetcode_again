package 无重复字符的最长子串3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 时间4 ms击败:87.48%内存:41.2 MB击败:93.23%
 *
 * @Date: 2023/1/3
 * @Author: feiWoSCun
 * @Description: abcanscvsj
 * @Email: 2825097536@qq.com
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abba";
        int i = solution.lengthOfLongestSubstring(str);
        System.out.println(i);
    }

    /**
     * mbcaaadbgbdgv
     * 腰酸背疼，好想去按摩店，呜呜呜
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        //记录最大
        int target = 0;
        //记录最最左边的数值
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //想紫砂了，这个判断条件憋了半天。。。
            if (map.containsKey(c) && map.get(c) >= left) {
                //这个数数组下标是真的烦人，草
                target = Math.max(target, i - left);
                //更新左边的指针
                left = map.get(c) + 1;
            }
            //记录每个元素的位置
            map.put(s.charAt(i), i);
        }
        //返回的时候，还要判断走到末尾的时候，是不是最大值......
        return Math.max(s.length() - left, target);
    }
}