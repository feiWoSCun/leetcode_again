package Honetooyoung.大二下.Powxn50;

class Solution {
    /*
    * 思路是：
    * 从效率方面考虑，不能一个x一个x乘到n次方，所以我们让x不断乘以自己以达到成指数式的增长
    * 先从n是偶数的角度看：（或者说n是2的指数）
    * x --->x^2 --->x^4 --->x^8 --->...--->x^n
    * n ---> n/2 --->n/4 ---> n/8--->...--->2--->1
    * x和次方是倒序对应的：1对应x，2对应x^2...
    * 这是最理想的思考方式，就是说n是2的指数
    * 这时候从n奇数的角度看：（或者说n不是2的指数）
    * 举例子：n为6
    * 6 --->3 --->1 （在n整型除以2时，就是3--->1）
    * x --->x^2--->x^4 这样不正确
    * 按顺序看x --->x^2 对应1--->2
    * 而1--->3 就对应x--->x^2--->x^3
    * 然后3--->6对应x^3--->x^6
    * 所以我们判断在n为奇数时，要多乘以一个x，来弥补在整型奇数除以2是忽略掉的精度
    *
    * 从另一个角度：
    * 因为我们是以自身倍数增长去做乘法，所以次方就可以看做是2的指数，或者说转换成二进制
    * 二进制遇到1乘以x，遇到0乘自己以自己
    * 比如说n为8对应二进制是1000，1--->x--->x^2--->x^4--->x^8
    * 比如说n为9对应二进制是1001，1--->x--->x^2--->x^4--->x^8--->x^9
    * 比如说n为10对应二进制是1010，1--->x--->x^2--->x^4--->x^5--->x^10
    * 也就是当n在 除以2时如果余1，二进制的相应位置为1
    * */

    public double myPow(double x, int n) {
        System.out.println(n);
        long N=n;
        System.out.println(N);
        return N>0?quickMul(x, N):1.0/quickMul(x,-N);
    }

    private double quickMul(double x, long n) {
        double ans=1.0;
        while (n>0){
            if (n%2==1){
                ans*=x;
            }
            x*=x;
            n/=2;
        }
        return ans;
    }

    public static void main(String[] args) {
        long a= -2147483648L;
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().myPow(2, (int)a));
        System.out.println(1.0 / 1363782929);
    }
}