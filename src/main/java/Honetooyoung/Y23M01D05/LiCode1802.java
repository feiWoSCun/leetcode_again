package Honetooyoung.Y23M01D05;

public class LiCode1802 {
    /*给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：

    nums.length == n
    nums[i] 是 正整数 ，其中 0 <= i < n
    abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
    nums 中所有元素之和不超过 maxSum
    nums[index] 的值被 最大化

返回你所构造的数组中的 nums[index] 。

注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。*/
    /*
    * https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array/description/*/
}

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int high = maxSum;
        int low = 1;
        int ans=-1;
        while (high > low+1) {
            long val1 = func(high, index, n)-high - maxSum;
            long val2 = maxSum - func(low, index, n)+low;
            if (val1 <= 0) {
                while (val1<=0){
                    val1=func(++high, index, n)-high - maxSum;
                }
                ans = high-1;
                break;
            } else if (val2 == 0) {
                ans = low;
                break;
            } else if (val1 == val2){
                ans = (low + high) / 2;
                ans+=func(ans+1, index, n)-ans-1 - maxSum<=0?1:0;
                break;
            }
            else if (val1 > val2)
                high = (low + high) / 2;
            else
                low = (low + high) / 2;
        }
        if(ans==-1){
            if(func(high, index, n)-high - maxSum<=0)
                ans=high;
            else if(maxSum - func(low, index, n)+low>0)
                ans=low;
        }
        return ans;
    }

    private long func(long count, int index, int n) {
        int num=Math.abs(n-index);
        long x,y;
        if (num<count)
            x= ((2*count-num+1)*num)/2;
        else
            x= (count+1)*count/2+num-count;
        if(index<count)
            y=((2*count-index)*(index+1))/2;
        else
            y=(count+1)*count/2+index+1-count;
        return x+y;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(4,2,808835420));
    }
}