package Honetooyoung.大二下.跳跃游戏55;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8, 6, 9, 1, 1, 6, 3, 5, 1, 2, 6, 6, 0, 4, 8, 6, 0, 3, 2, 8, 7, 6, 5, 1, 7, 0, 3, 4, 8, 3, 5, 9, 0, 4, 0, 1, 0, 5, 9, 2, 0, 7, 0, 2, 1, 0, 8, 2, 5, 1, 2, 3, 9, 7, 4, 7, 0, 0, 1, 8, 5, 6, 7, 5, 1, 9, 9, 3, 5, 0, 7, 5};
        System.out.println(new Solution().canJump2(nums));

    }

    public boolean canJump(int[] nums) {
        List<Integer> num = Arrays.stream(nums).boxed().toList();
        boolean ans = true;
        if (!num.contains(0) || num.size() == 1)
            return true;
        else {
            while (num.contains(0) && ans) {
                int index = num.indexOf(0);
                if (index == num.size() - 1)
                    return true;
                while (index + 1 < num.size() && num.get(index + 1) == 0) {
                    index++;
                }
                ans = false;
                int temp = 1;
                for (int i = 0; i < index; i++) {
                    if (num.get(i) >= num.size() - i - 1)
                        return true;
                    if (num.get(i) > index - i) {
                        ans = true;
                        temp = Math.max(temp, num.get(i) - index + i);
                    }
                }
                if (index + temp >= num.size() - 1 && ans) {
                    return true;
                } else {
                    num = num.subList(index + 1, num.size());
                }
            }
        }
        /*if(num.size()==0)
            return true;*/
        return ans;
    }
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
