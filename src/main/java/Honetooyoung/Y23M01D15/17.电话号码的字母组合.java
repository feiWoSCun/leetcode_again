package Honetooyoung.Y23M01D15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/*
* 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。*/
class Solution {
    HashMap<Integer, String> nineKey = new HashMap<>();
    List<String> ans = new ArrayList<>();
    StringBuffer temp = new StringBuffer();

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("234"));
    }

    public List<String> letterCombinations(String digits) {
        nineKey.put(2, "abc");
        nineKey.put(3, "def");
        nineKey.put(4, "ghi");
        nineKey.put(5, "jkl");
        nineKey.put(6, "mno");
        nineKey.put(7, "pqrs");
        nineKey.put(8, "tuv");
        nineKey.put(9, "wxyz");
        if (digits.length() != 0)
            dfs(digits);
        return ans;
    }

    public void dfs(String digits) {
        if (digits.length() != 0) {
            //拿出第一个数字
            int num = Integer.parseInt(String.valueOf(digits.charAt(0)));
            //数字对应的字符串
            String s = nineKey.get(num);
            //遍历字符串
            for (int i = 0; i < s.length(); i++) {
                //放入第i个字符
                temp.append(s.charAt(i));
                //进入下一层，把digits的第一个数字移除
                dfs(digits.substring(1));
                //移出第i个字符
                temp.deleteCharAt(temp.length() - 1);
            }
        } else {
            ans.add(temp.toString());
        }

    }
}