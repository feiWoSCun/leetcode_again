package feiWoSCun.合并二叉树617;

import feiWoSCun.TreeNode;

import javax.xml.transform.Source;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/6/3
 * @Email: 2825097536@qq.com
 */
public class Solution {

    public static void main(String[] args) throws Exception {
              final   CyclicBarrier cyclicBarrier = new CyclicBarrier(12, () -> {
            System.out.println(1);
        });
        for (int i = 0; i < 14; i++) {
            int finalI = i;
            Runnable r=()-> {
                System.out.println("这是第" + finalI + "次循环");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            };
            new Thread(r).start();
            };
        }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return null;
        }
        int x = 0;
        if (root1 != null) {
            x += root1.val;
        }
        if (root2 != null) {
            x += root2.val;
        }
        TreeNode treeNode = new TreeNode(x);
        if (root1 == null) {
            treeNode.left = mergeTrees(null, root2.left);
            treeNode.right = mergeTrees(null, root2.right);
        } else if (root2 == null) {
            treeNode.left = mergeTrees(root1.left, null);
            treeNode.right = mergeTrees(root1.right, null);
        } else {
            treeNode.left = mergeTrees(root1.left, root2.left);
            treeNode.right = mergeTrees(root1.right, root2.right);
        }


        return treeNode;
    }
}
