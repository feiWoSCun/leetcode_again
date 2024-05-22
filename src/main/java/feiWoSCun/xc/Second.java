package feiWoSCun.xc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2024/3/13
 * @Email: 2825097536@qq.com
 */
public class Second {

    public static void main(String[] args) {
        Scanner sca=new Scanner(System.in);
        int n =sca.nextInt();
        int[] arr=new int[n];
        double aver=0;
        for (int i = 0; i < n; i++) {
            int j = sca.nextInt();
            arr[i]=j;
            aver+=j;
        }

        for (int i=0;i<n;i++){
            System.out.println(Math.abs(arr[i]*n - aver));
        }

    }
}