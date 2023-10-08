package Honetooyoung.大二下.两数相除29;

class Solution {
    /*
    * 思路是：将除数一直叠加到被除数附近，记下有多少个被除数就是商
    * 如果将除数一个一个加，循环次数太多，所以通过将除数倍增，计数器也倍增的方式优化计算过程
    * 需要注意的是：因为被除数的范围是整型数的范围，也即-2147483648到2147483647，可以看出0到-2147483648涵盖的数字范围更广，因此我们将数字转换成负数，进行计算
    * 然后再根据除数和被除数判断正负
    * 计算思路是：
    * 让val（初始化为0）加除数，然后让除数加倍（自己加自己），再加到val，一直加到val大于被除数，
    * 然后回溯到上一层（val减掉上一次加的那个翻了若干倍的除数），
    * 重复之前的步骤（val从一倍除数开始加起），
    * 直到val加一倍除数，也大于被除数，即结束，输出加的除数的个数
    * */
    //判断深度搜索结束条件
    boolean flag=true;
    //商，通过加除数的个数得到结果
    int ans=0;
    public int divide(int dividend, int divisor) {
        //用于和被除数比较的val
        int val=0;
        //判断结果是否负数
        boolean isMinus=false;
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }
        //如果被除数大于零，转换成负数
        if(dividend>0){
            isMinus=true;
            dividend=-dividend;
        }
        //如果除数大于零，转换成负数
        if(divisor>0){
            isMinus=!isMinus;
            divisor=-divisor;
        }
        dfs(dividend,divisor,val);
        return isMinus?-ans:ans;
    }

    private void dfs(int dividend, int divisor,int val) {
        //计数器（是除数翻的倍数），用于加到ans结果中
        int count=1;
        //采用递归的方式进行加法，可以回到上一层的除数和val的值，如果用循环，除数翻倍后无法回到之前的倍数（不能用除法，不能除以2）
        //拿到val和计数器
        int[] arr=plus(val,dividend,divisor,count);
        //plus递归结束条件改为true
        flag=true;
        if (arr != null) {
            //如果计数器是1，说明val加一倍除数就已经大于被除数了，可以结束了，否则继续递归
            if (arr[1]!=1){
                dfs(dividend,divisor,arr[0]);
            }
        }
    }

    private int[] plus(int val, int dividend, int divisor,int count) {
        //用于返回结果，val和count
        int[] temp=null;
        //由于是对负数进行计算，所以应判断val是否小于被除数
        //当val<被除数或者val在的时候超出了负数范围变成了正数，返回到上一层
        if(val<dividend||val>0){
            flag=false;
            return null;
        }
        else{
            //先是排除val等于被除数的情况，其次如果除数超出最小整数范围，也停止递归
            if (val>dividend&&divisor<0){
                val+=divisor;
                ans+=count;
                temp=plus(val,dividend,divisor+divisor,count+count);
            }
            //从超出值那一层返回过来，输出val和count，一直返回
            if(!flag){
                val-=divisor;
                ans-=count;
                flag=true;
                return new int[]{val,count};
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().divide(1530093783, 1493139203
        ));
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}