package feiWoSCun.after20230708.leetcode.合并区间56;

import java.util.Arrays;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/18
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        solution.merge(array);
    }
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][0];
        }

        Arrays.sort(intervals,(a, b)->{
                    return  a[0]-b[0];
                }
        );
        int[][] res =new int[intervals.length][2];
        int index=0;
        int start=intervals[0][0];
        int  end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<end){
                end=Math.max(end,intervals[i][1]);
            }else{
                res[index][0]=start;
                res[index][1]=end;
                start=intervals[i][0];
                end=intervals[i][1];
                index++;
            }
        }
        res[index][0]=start;
        res[index][1]=end;
        //copy

        int[][] ans=new int[index+1][2];
        int j=0;
        while(j<=index){
            ans[j][0]=res[j][0];
            ans[j][1]=res[j][1];
            j++;
        }
        return ans;


    }
}