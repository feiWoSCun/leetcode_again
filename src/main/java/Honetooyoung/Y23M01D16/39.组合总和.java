package Honetooyoung.Y23M01D16;

import java.util.*;
/*
* 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。

对于给定的输入，保证和target 的不同组合数少于 150 个。*/

class Solution {
    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        System.out.println(new Solution().combinationSum(candidates, 8));
    }
    Deque<Integer> temp = new LinkedList<>();
    List<List<Integer>> ans=new ArrayList<>();
    int sum=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序
        Arrays.sort(candidates);
        //深度搜索
        dfs(candidates,target,0);
        return ans;
    }

    private void dfs(int[] candidates, int target,int j) {
        //总和达到target，加入答案
        if (sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int x = j; x<candidates.length; x++) {
            //超过target 不用遍历该位置，break
            if (sum+candidates[x]>target) break;
            sum+=candidates[x];
            temp.add(candidates[x]);
            dfs(candidates,target,x);
            //前面有入队操作，不用担心空指针异常
            sum-=temp.pollLast();
        }
    }
}