package feiWoSCun.xc;

import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/13
 * @Email: 2825097536@qq.com
 * //是you 不是y0u!
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s==null||s.length()<=2){
            System.out.println(s);
            return;
        }
        char[] chars = s.toCharArray();
        int[] array = new int[26];
        for (int i = 0; i < chars.length; i++) {
            array[chars[i]-'a']++;
        }
        final int y = 'y' - 'a';
        final int o = 'o' - 'a';
        final int u = 'u' - 'a';
        StringBuilder sb = new StringBuilder();
        while (array[y] != 0 && array[o] != 0 && array[u] != 0) {
            sb.append("you");
            array[y]--;
            array[o]--;
            array[u]--;
        }
        for(int i=0;i<26;i++){
            while (array[i]!=0){
                char c=(char) ('a'+i);
                sb.append(c);
                array[i]--;
            }
        }
        System.out.println(sb.toString());
    }
    //是对的吧？ huh?
}