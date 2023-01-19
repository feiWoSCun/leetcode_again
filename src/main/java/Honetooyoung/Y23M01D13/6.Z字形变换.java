package Honetooyoung.Y23M01D13;

import java.util.ArrayList;
import java.util.List;

/*
* 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。

比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：

P         A         H           N
A    P   L    S    I      I     G
Y         I           R                             */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 3));
    }
    public String convert(String s, int numRows) {
        int len = (s.length() / (3 * numRows - 2) + 5) * numRows;
        String[][] temp = new String[numRows][len];
        int i = 0, j = 0, x = 0;
        while (x < s.length()) {
            while (i < numRows && x<s.length()) {
                temp[i++][j] = String.valueOf(s.charAt(x++));
            }
            i--;
            while (i > 0 && x<s.length()) {
                temp[--i][++j] = String.valueOf(s.charAt(x++));
            }
            i++;
        }
        String ans="";
        for (int k = 0; k < numRows; k++) {
            for (int l = 0; l < len; l++) {
                if (temp[k][l]!=null)
                    ans+=temp[k][l];
            }
        }
        return ans;
    }
    public String Convert(int numRows,String s){
        if(numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<>();

        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());

        int i = 0, flag = -1;

        for(char c : s.toCharArray()) {

            rows.get(i).append(c);

            if(i == 0 || i == numRows -1) flag = - flag;

            i += flag;

        }

        StringBuilder res = new StringBuilder();

        for(StringBuilder row : rows) res.append(row);

        return res.toString();
    }
}