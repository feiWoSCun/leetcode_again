package feiWoSCun.after2024.hot128;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/21
 * @Email: 2825097536@qq.com
 */
public class lt128 {

}
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int res=1;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            if(map.containsKey(val)){
                continue;
            }else if(!map.containsKey(val+1)){
                Integer v= map.get(val-1);
                map.put(val,v+1);
                res=Math.max(res,map.get(val));
            } else{
                Integer v= map.get(val-1);
                if(v==null){
                    map.put(val,1);

                }else{
                    map.put(val,v+1);
                }
                int j=0;
                while(map.get(val+j+1)!=null){
                    ++j;
                }if(j!=0){
                    map.put(val+j,map.get(val)+j);
                    res=Math.max(res,map.get(val+j));
                }

            }
        }
        return res;
    }
}
