package 罗马数字转整数;

import java.util.ArrayList;
import java.util.LinkedList;

public class leet13 {
}

//创建分支
class Solution {
    public static void main(String[] args) {
     /*   String str = "LVIII";
        Solution solution = new Solution();
        int i = solution.romanToInt(str);
        System.out.println(i);*/
        long l = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("arrylist添加10万数据用时=" + String.valueOf(l1 - l));

        long l2 = System.currentTimeMillis();
        LinkedList<Integer> objects = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            objects.add(i);
        }
        long l3 = System.currentTimeMillis();
        System.out.println("linkedlist添加10万数据用时=" + String.valueOf(l3 - l2));
        compare();

    }

    public static void compare() {
        long l = System.currentTimeMillis();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println("arrylist添加1000万数据用时=" + String.valueOf(l1 - l));

        long l2 = System.currentTimeMillis();
        LinkedList<Integer> objects = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            objects.add(i);
        }
        long l3 = System.currentTimeMillis();
        System.out.println("linkedlist添加1000万数据用时=" + String.valueOf(l3 - l2));

    }

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