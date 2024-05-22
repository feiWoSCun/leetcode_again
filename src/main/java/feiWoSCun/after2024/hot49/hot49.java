package feiWoSCun.after2024.hot49;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/19
 * @Email: 2825097536@qq.com
 */
public class hot49 {

}

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        for (String s : strs) {
            this.judge(s);
        }
        return res;
    }

    List<List<String>> res = new ArrayList<>();


    private void judge(String str) {
        int index = -1;
        for (int i = 0; i < res.size(); i++) {
            int[] record = new int[26];
            String s = res.get(i).get(0);
            if (s.length() != str.length()) {
                continue;
            }
            char[] chars = s.toCharArray();

            for (int j = 0; j < chars.length; j++) {
                record[chars[j] - 'a']++;
            }
            char[] cs = str.toCharArray();
            for (int k = 0; k < cs.length; k++) {
                if (record[cs[k] - 'a'] <= 0) {
                    index=-2;
                    break;
                }
                record[cs[k] - 'a']--;
            }
            index =index==-2?-1: i;
            if (index>=0) {
                break;
            }
        }
        if (index != -1) {
            res.get(index).add(str);
        } else {
            List<String> temp = new ArrayList<>();
            temp.add(str);
            res.add(temp);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

    }
}
