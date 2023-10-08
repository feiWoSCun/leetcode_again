package feiWoSCun;

import jdk.jfr.Unsigned;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/5/23
 * @Email: 2825097536@qq.com
 */
public class Util {
    public static void main(String[] args) throws Exception {
        int a = (1 << 31) - 1;
        System.out.println(a);
        int b = 1;
        System.out.println(-a - b);
    }

    /**
     * 他妈的每次做二叉树测试样例都要去手动new，我选择撸一个工具类
     * 转换list,数组变成二叉树
     *
     * @param tar
     * @return
     */
    //这个与leetcode上面需要的构建二叉树方式不同，复杂度很高而且还有bug，所以遗弃
    @Deprecated
    public static TreeNode transArrToLinkedListWhichIsDeprecated(List<Integer> tar) {
        if (tar == null || tar.size() == 0) {
            return null;
        }
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
        for (int i = 1; i < res.size(); i++) {
            List<TreeNode> sureToAdd = res.get(i);
            //下标
            int j = 0;
            for (TreeNode node : temp) {
                if (j == sureToAdd.size()) {
                    break;
                }
                if (node == null) {
                    //这个地方要做手脚
                    TreeNode remove = sureToAdd.remove(sureToAdd.size() - 1);
                    TreeNode remove1 = sureToAdd.remove(sureToAdd.size() - 2);
                    if ((i + 1) < res.size()) {
                        List<TreeNode> next = res.get(i + 1);
                        next.add(0, remove);
                        next.add(0, remove1);
                        if (next.size() > right - left) {
                            int x = next.size() - right + left;
                            ArrayList<TreeNode> objects = new ArrayList<>(x);
                            for (int i1 = 0; i1 < x; i1++) {
                                objects.add(0, next.get(next.size() - 1 - i1));
                                next.remove(next.size() - 1 - i1);
                            }
                        }
                    }
                    continue;
                }
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

    /**
     * 层序排列
     * 采用两个队列。轮流记录
     *
     * @param tar
     * @return
     */

    public static TreeNode transArrToLinkedList(List<Integer> tar) {
        if (tar == null) {
            return null;
        }
        List<TreeNode> nowList = new LinkedList<>();
        List<TreeNode> nextList = new LinkedList<>();
        TreeNode first = new TreeNode(tar.get(0));
        //虚拟节点
        TreeNode head = new TreeNode();
        head.left = first;
        nowList.add(first);
        int j = 1;
        //判空
        while (null != nowList && !nowList.isEmpty()) {
            TreeNode t;
            for (int i = 0; i < nowList.size(); i++) {
                t = tar.get(j) == null ? null : new TreeNode(tar.get(j));
                //其实用poll也可以的，但是已经写了，就不改了
                TreeNode treeNode = nowList.get(i);
                if (t != null) {
                    nextList.add(t);
                }
                treeNode.left = t;
                if ((j = j + 1) < tar.size()) {
                    t = tar.get(j) == null ? null : new TreeNode(tar.get(j));
                    treeNode.right = t;
                    if (t != null) {
                        nextList.add(t);
                    }
                    j += 1;
                }
                if (j == tar.size()) {
                    //离开while
                    nowList = null;
                    break;
                }
            }
            if (nowList != null) {
                nowList.clear();
                //为什么不直接使用这个nowList=nextList而是挨着挨着赋值？;
                for (int i = 0; i < nextList.size(); i++) {
                    nowList.add(nextList.get(i));
                }
                //因为在浅拷贝的情况下，nextList的元素发生改变，nowList也会发生改变。
                nextList.clear();
            }

        }
        return head.left;
    }

    public static int[][] transferToIntNums(String nums) {
        String[] split = nums.replace("[", "").replace("]", "").replace("]]", "").replace("[[", "").split(",");
        int sqrt = (int) Math.sqrt(split.length);
        System.out.println(split.length);
        int arr[][] = new int[sqrt][sqrt];
        for (int i = 0; i < sqrt; i++) {
            for (int j = 0; j < sqrt; j++) {
                arr[i][j] = Integer.valueOf(split[sqrt * i + j]);
            }
        }
return arr;
    }


}
