package Honetooyoung.大二下.回溯.分割回文串131;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。

 */
public class Solution {
    List<List<String>> ans=new ArrayList<>();
    Deque<String> temp=new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
    }
    public List<List<String>> partition(String s) {
        backTracing(s,0);
        return ans;
    }

    private void backTracing(String s, int index) {
        //判断是否分割线index是否到最后，到达最后说明temp为一组答案
        if (index>=s.length()){
            ans.add(temp.stream().toList());
            return;
        }
        for (int i = index; i < s.length(); i++) {
            //判断index到i的子字符串是否为回文串
            if (isPalindrome(s,index,i)){
                temp.addLast(s.substring(index,i+1));
            }else continue;
            backTracing(s,i+1);
            temp.removeLast();
        }
    }

    private boolean isPalindrome(String s, int begin, int end) {
        while (begin<end){
            if (s.charAt(begin++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}