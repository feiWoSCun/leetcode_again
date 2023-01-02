package Honetooyoung.Y23M01D02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LiCode1801 {
}

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = {{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        int[][] data2 = {{7, 1000000000, 1}, {15, 3, 0}, {5,999999995, 0}, {5, 1, 1}};
        int[][] data3 = {{27,30,0},{10,10,1},{28,17,1},{19,28,0},{16,8,1},{14,22,0},{12,18,1},{3,15,0},{25,6,1}};
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
                if(buy.isEmpty() || sell.isEmpty())
                    break;
            }
            if(buy.isEmpty() || sell.isEmpty())
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
                if(buy.isEmpty() || sell.isEmpty())
                    break;
            }
        }
        while (!buy.isEmpty())
            ans += buy.poll()[1];
        while (!sell.isEmpty())
            ans += sell.poll()[1];
        return ans%mod;
    }
}
