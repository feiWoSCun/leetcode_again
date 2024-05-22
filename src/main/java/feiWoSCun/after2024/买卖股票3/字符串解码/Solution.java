package feiWoSCun.after2024.买卖股票3.字符串解码;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/1/16
 * @Email: 2825097536@qq.com
 */

class Solution {
    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = solution.decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }
    private final char left='[';
    private final char right=']';

    public String decodeString(String s) {
        char[] chars=s.toCharArray();
        int len =chars.length;
        StringBuilder res=new StringBuilder();
        for(int i=0;i<len;i++){
            char c=chars[i];
            if(Character.isLetter(c)){
                res.append(c);
            }else{
                //出现了数字
                Stack<Character> st=new Stack<>();
                st.push(c);
                i++;
                LinkedList<Character> list=new LinkedList<>();
                while(!st.isEmpty()){
                    char ch=chars[i];
                    if(ch==right){
                        while(st.peek()!=left){
                            list.offerFirst(st.pop());
                        }
                        //消除'[';
                        st.pop();
                        //找到数字
                        int mut=1;
                        int count=0;
                        while(!st.isEmpty()&&Character.isDigit(st.peek())){
                            int cell=(st.pop()-'0'+1);
                            cell*=mut;
                            mut*=10;
                            count+=cell;
                        }
                        list=resize(list,count);

                    }else{
                        st.push(chars[i]);
                    }
                    i++;
                }
                while(list.size()!=0){
                    res.append(list.pollFirst());
                }
            }

        }
        return res.toString();
    }

    private  int getDigit(String s,char[] tar,int index){
        int temp=index;
        temp+=1;
        while(temp<tar.length&&Character.isDigit(tar[temp])){
            temp++;
        }
        return Integer.parseInt(s.substring(index, temp));

    }

    private LinkedList<Character> resize(LinkedList<Character> list,int count){
        LinkedList temp= new LinkedList<>(list);
        while(count!=1){
            list.addAll(temp);
            count--;
        }
        return list;

    }
}