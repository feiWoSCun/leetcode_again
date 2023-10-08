package Honetooyoung.大二下.二叉树.路径总和III437;

import Honetooyoung.大二下.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    /*
    * 前缀和的思想是：在遍历一条路径的时候，记录下每次从根节点到此节点的所有节点和
    * 因为当前节点的前缀和是包含了之前节点前缀和，所以只需要找到当前前缀和减去前面的子路径的前缀和为target
    *举例：target=8
    *                             10
                    5                            -3
            3            2                #            11
        3    -2        #    1        #    #        #    #
    * 假设遍历最左边的路径，依次记录前缀和：①10、②10+5=15、③10+5+3=18、④10+5+3+3=21
    * 因为后面路径包含前面的路径，所以③-②得到的完整路径也是8即答案
    * 用hashmap存储前缀和以及该路径出现次数（例如：出现0或者有节点和为0的情况，那么零这个节点的前缀和下一个节点的前缀和是一样的但是是两条路径）
    * 遍历其他路径时删除非该路径的的节点的前缀和的记录
    * */
    public int ans;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        //当targetSum 等于某个节点值时，curPrefix - targetSum = 0,当前节点自己就算做一条符合条件的路径，所以也要计数
        prefix.put(0L, 1);
        dfs(root, prefix, 0L, targetSum);
        return ans;
    }

    //先序遍历
    private void dfs (TreeNode root, Map<Long, Integer> prefix, long curPrefix, int targetSum) {
        //递归终止的条件
        if (root == null) {
            return;
        }
        //当前节点的前缀和
        curPrefix += root.val;
        //查看是否有curPrefix - targetSum的前缀和已经存在
        int cnt = prefix.getOrDefault(curPrefix - targetSum, 0);
        ans += cnt;
        //记录前缀和
        prefix.put(curPrefix, prefix.getOrDefault(curPrefix, 0) + 1);
        //遍历左子树
        dfs(root.left, prefix, curPrefix, targetSum);
        //遍历右子树
        dfs(root.right, prefix, curPrefix, targetSum);
        //因为先序遍历是遍历根、左、右，即当前节点及其所有子节点，所以当遍历完当前节点和其所以子节点之后，当前节点的前缀和就没有用了，就需要把map里的记录删除，否则会影响其他子树的计算。跟当前节点没有路径关系的节点，不需要当前节点的前缀和
        prefix.put(curPrefix, prefix.getOrDefault(curPrefix, 0) - 1);
    }
}
