package feiWoSCun.找树左下角的值513;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import javax.print.attribute.standard.Fidelity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/31
 * @Email: 2825097536@qq.com
 */
public class Solution {
    // mn3. sTimer
    public static void main(String[] args) {
        String _s = "we";
        TreeNode treeNode = Util.transArrToLinkedList(Arrays.asList(2, 1, 3, 4, 3, 1, 2, 3, 4, null, null, null, null, null, null, null, 6));
        int bottomLeftValue = new Solution().findBottomLeftValue(treeNode);
        System.out.println(bottomLeftValue);
    }

    public int findBottomLeftValue(TreeNode root) {

   /*     int i = finBigLeft(new HashMap<>(16),root, Integer.MIN_VALUE, 0);
        return i;*/
        findBigLeft(root, 0);
        return maxLeft;
    }

    int height;
    int maxLeft;

    public void findBigLeft(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        findBigLeft(root.left, height);

        findBigLeft(root.right, height);
        if (this.height < height) {
            this.height = height;
            this.maxLeft = root.val;
        }
    }

}
