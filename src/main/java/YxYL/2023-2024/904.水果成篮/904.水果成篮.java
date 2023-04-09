import java.rmi.server.Skeleton;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;

/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int r = 0, l = 0; r < fruits.length; r++) {
            // 查看是否可以放值
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            // 超出背包范围
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
// @lc code=end
