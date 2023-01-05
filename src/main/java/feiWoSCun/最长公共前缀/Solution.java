package feiWoSCun.最长公共前缀;

/**
 * leetcode:14
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 * 题目: https://leetcode.cn/problems/longest-common-prefix/submissions/392537960/
 * 时间击败68.71%，内存击败62.70%
 * @author: feiWoSCun
 * @Time: 2023/1/3
 * @Email: 2825097536@qq.com
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower", "flower", "asdfagqw"};
        String s = solution.longestCommonPrefix(strs);
        System.out.println();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        if(strs.length==0){
            return "";
        }
        int j = 0;
        j = strs[0].length() <= strs[1].length() ? strs[0].length() : strs[1].length();
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < j; i++) {
            char c = strs[0].charAt(i);
            if (c == strs[1].charAt(i)) {
                stringBuilder.append(c);
            } else if (i == 0 && c != strs[1].charAt(i)) {
                return stringBuilder.toString();
            } else {
                break;
            }
        }
        for (int i = 2; i < strs.length; i++) {
            boolean b = isStart(strs[i], stringBuilder);
            //没有以那个开头，收缩
            while (!b &&stringBuilder.length() != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                b = isStart(strs[i], stringBuilder);
            }
            if (stringBuilder.length() == 0) {
                return stringBuilder.toString();
            }
        }


        return stringBuilder.toString();
    }

    public boolean isStart(String str, StringBuilder stringBuilder) {
        return str.startsWith(stringBuilder.toString());
    }
}