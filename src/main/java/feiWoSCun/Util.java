package feiWoSCun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/23
 * @Email: 2825097536@qq.com
 */
public class Util {
    public static void main(String[] args) {
        List<Integer> asList = Arrays.<Integer>asList(1, 2, 2, 4, 3, null, 5);
        TreeNode treeNode = new Util().transArrToLinkedList(asList);
        System.out.println(treeNode);
    }

    /**
     * 他妈的每次做测试样例都要去手动new，我选择撸一个工具类
     * 转换list,数组变成二叉树
     *
     * @param tar
     * @return
     */
    public TreeNode transArrToLinkedList(List<Integer> tar) {
        TreeNode treeNode = new TreeNode(tar.get(0));
        TreeNode[] treeNodes = new TreeNode[tar.size()];
        for (int i = 0; i < tar.size(); i++) {
            Integer integer = tar.get(i);
            treeNodes[i] = null;
            if (integer != null) {
                treeNodes[i] = new TreeNode(integer);
            }
        }
        List<TreeNode> nodes = Arrays.asList(treeNodes);
        int left = 0;
        int right = 1;
        List<List<TreeNode>> res = new ArrayList<>(16);
        while (right < nodes.size() * 2) {
            if (right > nodes.size()) {
                right = nodes.size();
            }
            List<TreeNode> list = nodes.subList(left, right);
            res.add(list);
            left = right;
            right = right * 2 + 1;
        }
        //最后一步，拼接
        TreeNode bef = new TreeNode(0);
        List<TreeNode> temp = res.get(0);
        bef.left = temp.get(0);
        for (int i = 1; i < res.size() - 1; i++) {
            List<TreeNode> sureToAdd = res.get(i);
            //下标
            int j = 0;
            for (TreeNode node : temp) {
                node.left = sureToAdd.get(j++);
                //防止越界
                if (j == sureToAdd.size()) {
                    break;
                }
                node.right = sureToAdd.get(j++);
            }
            //很重要的一步，转换
            temp = sureToAdd;
        }
        return bef.left;
    }
}
