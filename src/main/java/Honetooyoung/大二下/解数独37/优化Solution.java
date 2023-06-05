package Honetooyoung.大二下.解数独37;

import java.util.ArrayList;
import java.util.List;

public class 优化Solution {
    //记录每一排已经存在的数字，为true
    boolean[][] line =new boolean[9][9];
    //记录每一列已经存在的数字，为true
    boolean[][] column =new boolean[9][9];
    //记录每个九宫格已经存在的数字，为true
    //前两个维度定位九宫格的位置，最后的维度记录每个数字是否已存在
    boolean[][][] block =new boolean[3][3][9];
    //判断是否结束
    boolean flag=true;
    //存储未填数字坐标
    List<int[]> arrays=new ArrayList<>();
    public void solveSudoku(char[][] board) {
        //第一步将board中出现的数字更新到数组中
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    int num=board[i][j]-'0'-1;
                    line[i][num]=column[j][num]=block[i/3][j/3][num]=true;
                }else
                    arrays.add(new int[]{i,j});
            }
        }
        //深度搜索、回溯
        dfs(board,0);
    }

    private void dfs(char[][] board,int ptr) {
        //如果填满数字、结束
        if (ptr>=arrays.size()){
            flag=false;
        }else {
            //得到空白格子坐标
            int[] temp = arrays.get(ptr);
            int x =temp[0];
            int y =temp[1];
            for (int i = 0; i < 9&&flag; i++) {
                //判断i数字是否可以填入
                if (!line[x][i]&&!column[y][i]&&!block[x/3][y/3][i]){
                    board[x][y]= (char) (i + 1 + '0');
                    line[x][i]=column[y][i]=block[x/3][y/3][i]=true;
                    dfs(board,ptr+1);
                    //如果未填满，说明需要还原并试下一个数字，如果填满则退出
                    if(flag){
                        board[x][y]='.';
                        line[x][i]=column[y][i]=block[x/3][y/3][i]=false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        new 优化Solution().solveSudoku(board);
    }
}
