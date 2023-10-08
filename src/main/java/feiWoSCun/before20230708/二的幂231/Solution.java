package feiWoSCun.before20230708.二的幂231;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author: feiWoSCun
 * @Time: 2023/2/20
 * @Email: 2825097536@qq.com
 */
class Solution {
    
    public boolean isPowerOfTwo(int n) {
        //最短的leetcode
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("liuovbun");
        strings.add("liuovbun");
        strings.add("liuovbun");
        strings.add("liuovbun");
        Iterator<String> iterator = strings.iterator();
        strings.size();
       while (iterator.hasNext()){
           strings.remove(0);
       };

        for (String string : strings) {
            System.out.println();
        }
    }
}