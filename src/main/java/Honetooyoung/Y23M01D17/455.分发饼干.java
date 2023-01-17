package Honetooyoung.Y23M01D17;

import java.util.Arrays;
/*
* 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。

如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。

你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。*/
class Solution {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        System.out.println(new Solution().findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int k : s) {
            if (k >= g[j]) {
                ans++;
                j++;
            }
            if (j >= g.length)
                break;
        }
        return ans;
    }
}