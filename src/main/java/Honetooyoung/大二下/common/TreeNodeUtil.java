package Honetooyoung.大二下.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeUtil {
    public static TreeNode trans(Integer[] arr){
        //记录上一排节点
        ArrayList<TreeNode> pre = new ArrayList<>();
        //记录新一排节点(交替)
        ArrayList<TreeNode> next = new ArrayList<>();
        //指针
        boolean flag=true;
        if(arr.length<1){
            return null;
        }
        //根节点
        TreeNode root=new TreeNode(arr[0]);
        pre.add(root);
        int len=arr.length;//数组长度
        for (int i = 1; i < len; ) {
            //pre和next交替赋值
            ArrayList<TreeNode> temp1=flag?pre:next;
            ArrayList<TreeNode> temp2=!flag?pre:next;
            temp2.clear();//清空后装这一排的节点
            for (TreeNode node : temp1) {
                if(node!=null){
                    TreeNode left = arr[i] == null ? null : new TreeNode(arr[i]);//左节点
                    temp2.add(left);
                    node.left = left;
                    i++;
                    if (i>=len) break;
                    TreeNode right = arr[i] == null ? null : new TreeNode(arr[i]);//右节点
                    temp2.add(right);
                    node.right = right;
                    i++;
                    if (i>=len) break;
                }/*else {
                    if (++i>=len) break;
                    if (++i>=len) break;
                }*/
            }
            flag=!flag;
        }
        return root;
    }
    private static final List<List<TreeNode>> res=new ArrayList<>();
public static void print(TreeNode root){
    List<TreeNode> line = new ArrayList<>();//记录同一排的节点
    line.add(root);
    res.add(line);//记录每一排的节点，用于打印
    dfs(line);
    int len=res.size();//树的深度
    for (int x=0;x<len;x++) {
        //根据树的深度判断每一排打印多少前缀空格
        for (int i = 0; i <Math.pow(2,len-1-x)-1 ; i++) {
            System.out.print("    ");
        }
        List<TreeNode> treeNodes = res.get(x);
        for(int j=0;j<treeNodes.size();j++){//对当前排的遍历
            System.out.print(treeNodes.get(j)!=null?treeNodes.get(j).val:"#");
            //根据树的深度判断间隔
            for (int y = 0; y < Math.pow(2, len-x)-1; y++) {
                System.out.print("    ");
            }
            //每两个节点（也就是左右节点）增加空格
            if (j%2==1) {
                    System.out.print("    ");
            }
        }
        System.out.println();//换行
    }
    res.clear();
}
public static void dfs(List<TreeNode> list){
    int count=0;//判断是不是list全null
    for (TreeNode treeNode:list){
        if (treeNode!=null) break;
        else count++;
        }
    if (count==list.size()){
        res.remove(list);//移除全为null的一排
        return;
        }
    ArrayList<TreeNode> temp = new ArrayList<>();//记录下一排的每个节点
    for (TreeNode treeNode:list){
        if (treeNode!=null){
            temp.add(treeNode.left);
            temp.add(treeNode.right);
        }else {
            temp.add(null);
            temp.add(null);
        }
    }
    res.add(temp);
    dfs(temp);
}
    public static void main(String[] args) {
        TreeNode node = TreeNodeUtil.trans(new Integer[]{3,4,5,9,1,8,3,3,5,5,6,0,6,0,7,null,2,6,1,null,8,5,4,6,7,9,1,0,2,1,5,null,2,null,5,2,3,null,1,4,3,8,5,null,4,2,3,5,6,0,5,7,4,8,4,6,9,1,1,3,9});
        print(node);
    }
}
