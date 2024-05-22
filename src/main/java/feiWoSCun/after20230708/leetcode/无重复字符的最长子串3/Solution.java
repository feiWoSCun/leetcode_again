package feiWoSCun.after20230708.leetcode.无重复字符的最长子串3;

import java.util.HashMap;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: {DATE}
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        int tmmzuxt = new Solution().lengthOfLongestSubstring("tmmzuxt");

    }
    public int lengthOfLongestSubstring(String s) {
        int index=0;
        int res=0;
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> dp=new HashMap<>(16);
        for(int i=0;i<chars.length;i++){
            char c=chars[i];
            if(dp.containsKey(c)){
                index=dp.get(c)+1;
                dp.put(c,i);
            }
            else{
                res=Math.max(i-index+1,res);
                dp.put(c,i);
            }
        }
        return res;

    }
}