package Honetooyoung.年前.Y23M01D02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LiCode1801 {
    /**题目：
     * 给你一个二维整数数组orders,其中每个orders[i]=[price,amount,orderType]
     * 表示有amount笔类型为orderType、价格为price的订单。
     * 订单类型orderType可以分为两种：
     * 0 表示这是一批采购订单buy
     * 1 表示这是一批销售订单sell
     * 注意，
     * orders[i]表示一批共计amount:笔的独立订单，这些订单的价格和类型相同。
     * 对于所有有效的i,由orders[i]表示的所有订单提交时间均早于orders[i+1]表示的所有订单。
     * 存在由未执行订单组成的积压订单。积压订单最初是空的。提交订单时，会发生以下情况：
     * 如果该订单是一笔采购订单buy,则可以查看积压订单中价格最低的销售订单sLL。
     * 如果该销售订单sell的价格低于或等于当前采购订单buy的价格，则匹配并执行这两笔订单，并将销售订单
     * sell从积压订单中删除。否则，采购订单buy将会添加到积压订单中。
     * 反之亦然，如果该订单是一笔销售订单sell,则可以查看积压订单中价格最高的采购订单buy。
     * 如果该采购订单buy的价格高于或等于当前销售订单sL1的价格，则匹配并执行这两笔订单，并将采购订单buy从积压订单中删除。否则，销售订单seL1将会添加到积压订单中。
     * 输入所有订单后，返回积压订单中的订单总数。由于数字可能很大，所以需要返回对1e9+7取余的结果。*/
    /*我的理解是所有订单直接给出积压订单最少的解
     * 但是，官方的意思是按照orders的订单顺序 抵消订单
     * 因此，我的getNumberOfBacklogOrders方法在数据三时与答案不同 积压订单更少
     * 官方题解getNumberOfBacklogOrders2方法更多*/
}

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = {{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        int[][] data2 = {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        int[][] data3 = {{27, 30, 0}, {10, 10, 1}, {28, 17, 1}, {19, 28, 0}, {16, 8, 1}, {14, 22, 0}, {12, 18, 1}, {3, 15, 0}, {25, 6, 1}};
        System.out.println(solution.getNumberOfBacklogOrders2(data3));
        System.out.println(solution.getNumberOfBacklogOrders(data3));
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        int ans = 0;
        final int mod = (int) 1e9 + 7;
        PriorityQueue<int[]> buy = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] order : orders) {
            if (order[2] == 0) {
                buy.offer(order);
            } else
                sell.offer(order);
        }
        while (!buy.isEmpty() && !sell.isEmpty()) {
            while (buy.peek()[0] < sell.peek()[0]) {
                ans += buy.poll()[1];
                if (buy.isEmpty())
                    break;
            }
            if (buy.isEmpty())
                break;
            while (buy.peek()[0] >= sell.peek()[0]) {
                if (buy.peek()[1] == sell.peek()[1]) {
                    buy.poll();
                    sell.poll();
                } else if (buy.peek()[1] > sell.peek()[1]) {
                    buy.peek()[1] -= sell.poll()[1];
                } else {
                    sell.peek()[1] -= buy.poll()[1];
                }
                if (buy.isEmpty() || sell.isEmpty())
                    break;
            }
        }
        while (!buy.isEmpty())
            ans += buy.poll()[1];
        while (!sell.isEmpty())
            ans += sell.poll()[1];
        return ans % mod;
    }

    public int getNumberOfBacklogOrders2(int[][] orders) {
        final int MOD = 1000000007;
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {
                while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= price) {
                    int[] sellOrder = sellOrders.poll();
                    int sellAmount = Math.min(amount, sellOrder[1]);
                    amount -= sellAmount;
                    sellOrder[1] -= sellAmount;
                    if (sellOrder[1] > 0) {
                        sellOrders.offer(sellOrder);
                    }
                }
                if (amount > 0) {
                    buyOrders.offer(new int[]{price, amount});
                }
            } else {
                while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= price) {
                    int[] buyOrder = buyOrders.poll();
                    int buyAmount = Math.min(amount, buyOrder[1]);
                    amount -= buyAmount;
                    buyOrder[1] -= buyAmount;
                    if (buyOrder[1] > 0) {
                        buyOrders.offer(buyOrder);
                    }
                }
                if (amount > 0) {
                    sellOrders.offer(new int[]{price, amount});
                }
            }
        }
        int total = 0;
        for (PriorityQueue<int[]> pq : Arrays.asList(buyOrders, sellOrders)) {
            while (!pq.isEmpty()) {
                int[] order = pq.poll();
                total = (total + order[1]) % MOD;
            }
        }
        return total;
    }
}
