package feiWoSCun.二叉树的所有路径257;

import feiWoSCun.TreeNode;
import feiWoSCun.Util;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/27
 * @Email: 2825097536@qq.com
 */
public class Solution {
    List<String> res = new ArrayList<>();
    StringBuffer buff = new StringBuffer();

    public static void main(String[] args) {
/*        TreeNode treeNode = Util.transArrToLinkedList(Arrays.asList(37, -34, -48, null, -100, -100, 48, null, null, null, null, -54, null, -71, -22, null, null, null, 8));
        List<String> strings = new Solution().binaryTreePaths(treeNode);
        System.out.println(strings);*/
        String s = "";
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s += "wocao尼玛";
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        StringBuffer buf=new StringBuffer("");
        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            buf.append("wocao尼玛");
        }
        long l3 = System.currentTimeMillis();
        System.out.println(l3-l2);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left == root.right) {
            res.add(String.valueOf(root.val));
            return res;
        }
        findPathes(root, buff);
        return res;
    }

    private void findPathes(TreeNode root, StringBuffer s) {
        if (root == null) {
            s.append("-->");
            return;
        }
        s.append(root.val);
        s.append("->");
        if (root.left == root.right) {
            //System.out.println(s.length());
            res.add(s.substring(0, s.length() - 2));

            return;
        }
        findPathes(root.left, s);
        s.delete(s.length() - 3, s.length());
        findPathes(root.right, s);
        s.delete(s.length() - 3, s.length());
    }


    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>(16);
        findPathes1(root, "", res);
        return res;
    }

    private void findPathes1(TreeNode root, String s, List<String> res) {
        if (root != null) {
            s += root.val;
            if (root.left == root.right) {
                res.add(s);
            } else {
                s += "->";
                findPathes1(root.left, s, res);
                findPathes1(root.right, s, res);
            }
        }
    }


}
