package Honetooyoung.年前.Y23M01D12;

import java.util.ArrayList;
import java.util.List;

/*给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。*/

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        //深度搜索
        dfs(ans, n, k, item, 1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int n, int k, List<Integer> item, int i) {
        if (i == k + 1) {
            ans.add(new ArrayList<>(item));
            return;
        }
        //i代表深度搜索所在的层数
        //j应该为上一个数+1
        //j小于等于最大数n减去个数k和层数i的差
        for (int j = item.size() == 0 ? 1 : item.get(item.size() - 1) + 1; j <= n - (k - i); j++) {
            item.add(j);
            dfs(ans, n, k, item, i + 1);
            item.remove(item.size() - 1);
        }
    }
}