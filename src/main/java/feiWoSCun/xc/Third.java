package feiWoSCun.xc;

import java.awt.font.NumericShaper;
import java.sql.Array;
import java.util.*;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/13
 * @Email: 2825097536@qq.com
 */
public class Third {
    //第三题 看一下 我的复杂度太高了
    public static void main(String[] args) {
        Scanner sca=new Scanner(System.in);
        Map<String,String> res=new HashMap<>(16);
        String s = sca.nextLine();
        int l=1;
        int r=1;
        List<String> lists=new ArrayList<>();
        while (r<s.length()-1) {
            while(r<s.length()-1&&s.charAt(r)!=','){
                r++;
            }
            String str=s.substring(l,r);
            int p1=0;
            int p2=0;
            while (str.charAt(p2)!='('){
                p2++;
            }
            String num1=(str.substring(p1,p2));
            if(lists.size()==0||!lists.get(lists.size()-1).equals(num1)){
                lists.add(num1);
            }
            String num2 = str.substring(p2+1, str.length()-1);

            String i1 = res.get(num1);
            if (i1!=null){
                res.put(num1, String.valueOf((Integer.valueOf(num2)+Integer.valueOf(i1))));
            }
            else{
                res.put(num1,num2);
            }
            l=r;
            r++;
            l++;
        }
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("[");
        for (int i=0 ;i<lists.size();i++) {
            String key = lists.get(i);
            String value = res.get(key);
            stringBuilder.append(key);
            stringBuilder.append("(");
            stringBuilder.append(value);
            stringBuilder.append(")");
            if (i!=lists.size()-1) {
                stringBuilder.append(",");
            }

        }

        System.out.println(stringBuilder.append( "]"));

    }
}