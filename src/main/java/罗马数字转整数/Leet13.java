package 罗马数字转整数;

public class Leet13 {
}
//创建分支
class Solution {
    public static void main(String[] args) {
        String str = "LVIII";
        Solution solution = new Solution();
        int i = solution.romanToInt(str);
        System.out.println(i);
    }
//hello
    public int romanToInt(String s) {
        //临时储存结果
        int temp = 0;
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            int j = getNum(s.charAt(i));
            if (i < length - 1) {
                int k = getNum(s.charAt(i + 1));
                if (j < k) {
                    temp += k - j;
                    i += 1;
                    continue;
                }
            }
            temp += j;
        }
        return temp;
    }

    /*public boolean compare(char before, char after) {
        return true;
    }*/

    public int getNum(char a) {
        switch (a) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}