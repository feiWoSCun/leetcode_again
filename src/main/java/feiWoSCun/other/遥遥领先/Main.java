package feiWoSCun.other.遥遥领先;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/3
 * @Email: 2825097536@qq.com
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] works = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = scanner.nextInt();
        Solution solution = new Solution(works, N);
        System.out.println(solution.solve());
    }

}

class Solution {
    public    int N  ;
    public final int[] works;

    public Solution(int[] works, int n) {
        this.N=n;
        this.works=works;
    }

    public int solve() {
        int l=Arrays.stream(works).max().getAsInt()-1;
        int r=Arrays.stream(works).sum();
        while (l+1<r){
            int mid=(l+r)>>1;
            if(ok(0,mid,new int[N])){
                r=mid;
            }else {
                l=mid;
            }
        }
        return r;
    }

    private boolean ok(int idx, int MAX_SUM, int[] sums) {
        if(idx==works.length){
            return true;
        }
        for (int i = 0; i < N; i++) {

            if (sums[i]+works[idx]<=MAX_SUM) {
                sums[i]+=works[idx];
                if(ok(idx+1,MAX_SUM,sums)){
                return true;
                }
                sums[i]-=works[idx];
            }
        }
        return false;
    }
}
