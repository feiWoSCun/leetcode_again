package feiWoSCun.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/4/11
 * @Email: 2825097536@qq.com
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words={"foo","bar"};
        String str="barfoothefoobarman";
        List<Integer> substring = solution.findSubstring(str, words);

    }
    public List<Integer> findSubstring(String s, String[] words) {
        this.words_num=words.length;
        this.words_length=words[0].length();
        this.count=this.words_length*this.words_num;
        int p1=0;
        int p2=count;
        List<Integer> res=new ArrayList<>();
        this.map=new HashMap<>();
        for (String word : words) {
            this.map.put(word,this.map.getOrDefault(word,0)+1);
        }
        while(p2<=s.length()){
            String str=s.substring(p1,p2);
            if(this.ifSub(str)){
                res.add(p1);
            }
            p2++;
            p1++;
        }
        return res;
    }
    int words_length;
    int words_num;
    int count;
    Map<String,Integer> map;
    private  boolean ifSub(String sub){
        int begin=0;
        Map<String ,Integer> t_map=new HashMap<>();
        while(begin+words_length<=count){
            String str=sub.substring(begin,begin+words_length);
            t_map.put(str,t_map.getOrDefault(str,0)+1);
            begin+=words_length;
        }
        return t_map.equals(map);

    }

}