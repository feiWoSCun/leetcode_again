package Honetooyoung.大二下.接雨水42;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int ans=0;
        int len=height.length;
        int max = Arrays.stream(height).max().orElse(0);
        boolean [][] dp=new boolean[max][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < height[i]; j++) {
                dp[j][i]=true;
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]){
                    int count=0;
                    j++;
                    while (j<len){
                        if (!dp[i][j++]) {
                            count++;
                        }else {
                            ans+=count;
                            count=0;
                        }
                    }
                }
            }
        }
        return ans;
    }
    public int trap2(int[] height) {
        int ans=0;
        int len=height.length;
        int max = Arrays.stream(height).max().orElse(0);
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < len; j++) {
                if (height[j]>=i+1){
                    int count=0;
                    j++;
                    while (j<len){
                        if (height[j++]<i+1) {
                            count++;
                        }else {
                            ans+=count;
                            count=0;
                        }
                    }
                }
            }
        }
        return ans;
    }
    public int trap3(int[] height) {
                int res = 0, h1 = 0, h2 = 0;
                for(int i = 0, j = height.length-1; i < height.length && j >= 0; i ++, j--) {
                    h1 = Math.max(h1, height[i]);
                    h2 = Math.max(h2, height[j]);
                    res += h1 + h2 - height[i];
                }
                return res - height.length * h1; // 再减去整个矩形面积
    }
        public int trap4(int[] height) {
            int n = height.length;
            if (n <= 2) return 0;
            int[] left = new int[n], right = new int[n];
            // 这里初始化必须取实际值
            left[0] = height[0];
            right[n - 1] = height[n - 1];
            for (int i = 1; i < n; i++) {
                left[i] = Math.max(left[i - 1], height[i]);
            }
            for (int i = n - 2; i >= 0; i--) {
                right[i] = Math.max(right[i + 1], height[i]);
            }
            int res = 0;
            for (int i = 1; i <= n - 2; i++) {
                // 短板
                int min = Math.min(left[i], right[i]);
                if (min > height[i]) res += min - height[i];
            }
            return res;
    }
    public int trap5(int[] walls) {
        if (walls == null || walls.length <= 2) {
            return 0;
        }

        // 思路：
        // 单调不增栈，walls元素作为右墙依次入栈
        // 出现入栈元素（右墙）比栈顶大时，说明在右墙左侧形成了低洼处，低洼处出栈并结算该低洼处能接的雨水

        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int right=0; right<walls.length; right++) {
            // 栈不为空，且当前元素（右墙）比栈顶（右墙的左侧）大：说明形成低洼处了
            while (!stack.isEmpty() && walls[right]>walls[stack.peek()]) {
                // 低洼处弹出，尝试结算此低洼处能积攒的雨水
                int bottom = stack.pop();
                // 看看栈里还有没有东西（左墙是否存在）
                // 有右墙+有低洼+没有左墙=白搭
                if (stack.isEmpty()) {
                    break;
                }

                // 左墙位置以及左墙、右墙、低洼处的高度
                int left = stack.peek();
                int leftHeight = walls[left];
                int rightHeight = walls[right];
                int bottomHeight = walls[bottom];

                // 能积攒的水=(右墙位置-左墙位置-1) * (min(右墙高度, 左墙高度)-低洼处高度)
                water += (right-left-1) * (Math.min(leftHeight, rightHeight)-bottomHeight);
            }

            // 上面的pop循环结束后再push，保证stack是单调不增
            stack.push(right);
        }

        return water;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().trap5(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}