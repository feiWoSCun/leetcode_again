package Honetooyoung.大二下.回溯.跳跃游戏II45;

public class Solution {
        public static void main(String[] args) {
                int[] nums={4,1,1,3,1,1,1};
                System.out.println(new Solution().jump(nums));
        }
        public int jump(int[] nums) {
                int ans=0;
                int i=0;
                int len= nums.length;
                while (i<len-1){
                        int n=nums[i];
                        if(n+i>=len-1)
                                return ans+1;
                        int max=0;
                        int x=0;
                        for (int j = i+1; j < n+i+1; j++) {
                                if(j+nums[j]>max){
                                        max=nums[j]+j;
                                        x=j;
                                }
                                if (j>=len-1)
                                        break;
                        }
                        i=x;
                        ans++;
                }
                return ans;
        }
}
