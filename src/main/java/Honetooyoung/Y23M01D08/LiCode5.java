package Honetooyoung.Y23M01D08;

public class LiCode5 {
    /*
    * 给你一个字符串 s，找到 s 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。*/
}

class Solution {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); //获取开始时间
        System.out.println(new Solution().longestPalindrome("aaaabaaa"));
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    public String longestPalindrome(String s) {
        //答案字符串
        String ans = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length()&&s.length()-i>ans.length(); i++) {
            //遍历查找首位相同的子字符串，找到从末位开始与i位置相同的字符的index
            int index = s.lastIndexOf(s.charAt(i));
            while (index > i) {
                //截取首尾相同字符的字符串
                String str = s.substring(i, index + 1);
                String temp = str;
                //循环去除首位相同的字符
                while (temp.charAt(0) == temp.charAt(temp.length() - 1) && temp.length() > 1) {
                    temp = temp.substring(1, temp.length() - 1);
                    if (temp.equals("")) break;
                }
                if (temp.equals("") || temp.length() == 1) {
                    ans = ans.length() > str.length() ? ans : str;
                    //下面代码可以提高运行速度 但是会导致部分用例无法通过
                    /*if (ans.length()<str.length()){
                        ans=str;
                        if (ans.length() % 2 == 0)
                            i = index;
                        else{
                            i = index - ans.length() / 2-1;
                            break;
                        }
                    }*/
                }
                index = s.lastIndexOf(s.charAt(i), index-1);
            }
        }
        return ans;
    }
}
