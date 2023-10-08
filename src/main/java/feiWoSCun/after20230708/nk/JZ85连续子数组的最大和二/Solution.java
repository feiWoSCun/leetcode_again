package feiWoSCun.after20230708.nk.JZ85连续子数组的最大和二;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/9/9
 * @Email: 2825097536@qq.com
 */

import feiWoSCun.TreeNode;
import feiWoSCun.Util;
import org.w3c.dom.Node;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;


public class Solution {
    public static void main(String[] args) {
        int[] array = {2, 8, 1, 5, 9};

        int[] ints = new Solution().FindGreatestSumOfSubArray(array);
        System.out.println(ints);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindGreatestSumOfSubArray(int[] array) {
        // write code here
        int[] dp = new int[array.length];
        int max = array[0];
        int left = 0;
        int right = 0;
        int resl = 0;
        int resr = 0;
        for (int i = 1; i < array.length; i++) {
            right++;
            if (dp[i - 1] + array[i] > array[i]) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
                left = right;
            }
            //用来更新的
            if (dp[i] > max || (max == dp[i] && ((right - left) > resr - resl))) {
                max = dp[i];
                resl = left;
                resr = right;
            }
        }
        return copyNums(array, resl, resr);
    }

    private int[] copyNums(int[] nums, int left, int right) {
        int[] res = new int[right - left + 1];
        System.arraycopy(nums, left, res, 0, right - left + 1);
/*      final ExecutorService executorService = newCachedThreadPool();
        final List;
        CompletableFuture completableFuture = new CompletableFuture();
        List<String> strings = Arrays.asList("sdfv", "asdf", "Asdfasd");
        strings.parallelStream().forEach(t -> {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    //
                }
            })
        });*/
        return res;
    }
    public  boolean ifTrue(TreeNode l, TreeNode r){
 if(l==null&&r==null){

 }if(l==null||r==null){

 }
        return  ifTrue(l.left,r.left)||ifTrue(l.right,r.right);
    }


}