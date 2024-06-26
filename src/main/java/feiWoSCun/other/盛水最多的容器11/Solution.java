package feiWoSCun.other.盛水最多的容器11;

/**
 * @description: 你好
 * @author: feiWoSCun
 * @Time: 2023/3/24
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
    public int maxArea(int[] height) {
        int length = height.length - 1;
        int left = height[0];
        int right = height[length];
        int capicity = 0;
        int j = length, i = 0;
        do {
            if (i == j) {
                break;
            }
            int minSide = Math.min(height[j], height[i]);
            int nowCap = (j-i )* minSide;
            if (nowCap > capicity) {
                capicity = nowCap;
            }
                if (height[i] <= height[j]) {
                    i++;
                } else {
                    j--;
                }
        } while (true);
        return capicity;
    }

}