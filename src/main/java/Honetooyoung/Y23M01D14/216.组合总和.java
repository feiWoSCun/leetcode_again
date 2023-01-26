package Honetooyoung.Y23M01D14;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().combinationSum3(3, 15));
        long end = System.currentTimeMillis();
        System.out.println(start - end);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if ((1 + k) * k / 2 > n || n > k * 9) {
            return ans;
        } else {
            dfs2(k, n, ans, temp, 1);
        }
        return ans;
    }

    public void dfs2(int k, int n, List<List<Integer>> ans, List<Integer> temp, int cur) {
        //深度搜索到最后一层
        if (cur == k) {
            //算出最后一个值
            int val = 0;
            for (Integer integer : temp) {
                val += integer;
            }
            val = n - val;
            //如果大于9就返回倒上一层
            if (val > 9) {
                return;
            }
            //如果大于上一层，则重复，就说明上一层已经到最大，回到上上层
            else if (val <= temp.get(temp.size() - 1)) {
                temp.set(temp.size() - 1, 10);
                return;
            }
            //放入答案
            else {
                temp.add(val);
                ans.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                return;
            }
        }
        //循环x应该从比上一层大1开始，若没有则从1开始
        int x = temp.size() != 0 ? temp.get(temp.size() - 1) + 1 : 1;
        while (x < 10) {
            temp.add(x);
            dfs2(k, n, ans, temp, cur + 1);
            //(优化)在第一层数值不可能比平均值大
            if (cur == 1 && x > n / k)
                break;
            //正常来说这两个值是相等的，诸如当出现倒数第一层已经大于倒数第二层时，没必要进行接下来的循环，则让x变为跳出循环的值
            x = temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
            x++;
        }
    }
}