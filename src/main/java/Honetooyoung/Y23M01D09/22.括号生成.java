package Honetooyoung.Y23M01D09;

import java.util.ArrayList;
import java.util.List;
/*
* 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。*/
class Solution {
    List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(8));
    }

    public List<String> generateParenthesis(int n) {
        if (n < 1)
            return ans;
        func(n, n, "");
        return ans;
    }

    public void func(int left, int right, String str) {
        if (right == 0 && left == 0) {
            ans.add(str);
            return;
        }
        if (right == left) {
            func(left - 1, right, str + "(");
        } else if (right > left) {
            if (left > 0)
                func(left - 1, right, str + "(");
            func(left, right - 1, str + ")");
        }
    }
}