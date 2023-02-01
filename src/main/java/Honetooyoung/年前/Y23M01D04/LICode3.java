package Honetooyoung.年前.Y23M01D04;

import java.util.HashMap;
import java.util.PriorityQueue;

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
    public int lengthOfLongestSubstringPro(String s) {
        PriorityQueue<String> queue=new PriorityQueue<>((s1, t1) -> t1.length()- s1.length());
        int right=0,left=0;
        for (; right < s.length(); right++) {
            if(s.substring(left,right).contains(String.valueOf( s.charAt(right)))){
                queue.offer(s.substring(left,right));
                left=s.substring(left).indexOf(s.charAt(right))+1+left;
            }
        }
        queue.offer(s.substring(left));
        return queue.poll().length();
    }
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringPro("abbabdkbdhhhhsbsbsb"));
    }
}
