package Honetooyoung.大二下.组合总和II40;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    boolean flag=false;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

         Arrays.sort(candidates);
        Deque<Integer> temp = new ArrayDeque<>();
        backTracing(candidates,0,temp,0,target);
        return ans;
    }

    private void backTracing(int[] list, int ptr,Deque<Integer> temp,int val,int target) {
        if (val==target){
            if(!ans.contains(temp.stream().toList()))
                ans.add(new ArrayList<>(temp));
            flag=true;
        } else if (val>target) {
            flag=true;
        }else {
            for (int i = ptr; i < list.length; i++) {
                if (i>ptr&& Objects.equals(list[i], list[i-1]))continue;
                temp.add(list[i]);
                backTracing(list,i+1,temp,val+list[i],target);
                temp.removeLast();
                if (flag){
                    flag=false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Solution().combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},30).forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}