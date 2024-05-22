package feiWoSCun.some_learn.class测试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/29
 * @Email: 2825097536@qq.com
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s="ababcbacadefegdehijhklij";
        solution.partitionLabels(s);
    }

    public List<Integer> partitionLabels(String s) {
        int begin = 'a';
        int end = 'z';
        int[][] temp = new int[end - begin + 1][2];
        for (int[] ints : temp) {
            ints[0]=Integer.MAX_VALUE;
        }
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i]-'a';
            temp[index][0] = Math.min(temp[index][0], i);
            temp[index][1] = Math.max(temp[index][1], i);
        }
        //合并区间
        int[][] merge = this.merge(temp);
        List<Integer> res=new ArrayList<>();
        for (int[] ints : merge) {
            int i = ints[1] - ints[0];
            if (i >= 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (a, b) -> {
                    return a[0] - b[0];
                }
        );
        int[][] res = new int[intervals.length][2];
        int index = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            } else {
                res[index][0] = start;
                res[index][1] = end;
                start = intervals[i][0];
                end = intervals[i][1];
                index++;
            }
        }
        res[index][0] = start;
        res[index][1] = end;
        //copy

        int[][] ans = new int[index + 1][2];
        int j = 0;
        while (j <= index) {
            ans[j][0] = res[j][0];
            ans[j][1] = res[j][1];
            j++;
        }
        return ans;


    }
}