package Honetooyoung.Y23M01D06;

public class LiCode2180 {
    /*
    * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。

        正整数的 各位数字之和 是其所有位上的对应数字相加的结果。*/
}
class  Solution{
    public int countEven(int num){
        int y=num/10,x=num%10;
        int ans=5*y;
        int sum=0;
        while (y!=0){
            sum+=y%10;
            y/=10;
        }
        if (sum%2==0){
            ans+=x/2+1;
        }else
            ans+=(x+1)/2;
        return ans-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countEven(30));
    }
}