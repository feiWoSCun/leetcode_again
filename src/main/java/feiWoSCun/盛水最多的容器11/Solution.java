package feiWoSCun.盛水最多的容器11;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/4/9
 * @Email: 2825097536@qq.com
 */
class Solution {

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
            int minSide = height[j] >= height[i] ? height[i]: height[j];
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