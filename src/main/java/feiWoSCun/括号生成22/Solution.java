package feiWoSCun.括号生成22;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/18
 * @Email: 2825097536@qq.com
 */
class Solution {
    List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return null;
        }
        res("",0,0,n);
        return res;
    }

    private void res(String tar, int left, int right, int n) {
        if (right > left || left > n) {
            return ;
        }
        if (tar.length() == n * 2) {
            res.add(tar);
            return;
        }
        res(tar+"(", left + 1, right, n);
        res(tar+")", right, left + 1, n);
    }
}