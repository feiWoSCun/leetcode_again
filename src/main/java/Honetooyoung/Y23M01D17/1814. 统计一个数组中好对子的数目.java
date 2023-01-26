package Honetooyoung.Y23M01D17;

import java.util.HashMap;

/*
* 给你一个数组nums，数组中只包含非负整数。定义rev(x)的值为将整数x各个数字位反转得到的结果。比方说rev(123) = 321，rev(120) = 21。我们称满足下面条件的下标对(i, j) 是好的：

    0 <= i < j < nums.length
    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])

请你返回好下标对的数目。由于结果可能会很大，请将结果对1e9 + 7取余后返回。*/
//思路是反转前后差值相同的数字能满足条件，用哈希表计数每个差值的次数，次数大于1的，进行阶乘求和得到答案
//遇到问题在于数字过大取余的问题，因为是通过计算得出答案，所以需要转为long型避免数值丢失，单个答案需要取余，求和也需要取余
class Solution2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {2, 3, 41, 2, 56, 764, 23};
        long end = System.currentTimeMillis();
        System.out.println(new Solution2().countNicePairs(nums));
        System.out.println(end - start);
    }

    public int countNicePairs(int[] nums) {
        int ans;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i :
                nums) {
            //得出反转前后差值
            int val = reverse(i);
            //放入map中计数
            map.put(val, map.containsKey(val) ? map.get(val) + 1 : 1);
        }
        //通过流计算总和
        ans = map.keySet().stream().mapToInt(map::get).filter(count -> count > 1).map(count -> (int) (((long) count * (long) (count - 1) / 2) % 1000000007)).sum();
        return ans % 1000000007;
    }

    private int reverse(int i) {
        int j = i;
        while (j % 10 == 0 && j != 0) j /= 10;
        int reverse = 0;
        while (j != 0) {
            reverse = reverse * 10 + j % 10;
            j /= 10;
        }
        return i - reverse;
    }
}