package Honetooyoung.Y23M01D04;

import java.util.HashMap;

public class LICode3 {
    /*
    * https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
    * */
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。*/
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        if(s.length()==0)
            return 0;
        int pointer=0;
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                pointer= Math.max(map.get(s.charAt(i)) + 1, pointer);
            }
            map.put(s.charAt(i),i);
            ans= Math.max(i - pointer + 1, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }
}
