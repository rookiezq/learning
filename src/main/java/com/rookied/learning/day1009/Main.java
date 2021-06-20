package com.rookied.learning.day1009;

import java.util.*;

public class Main{


    public static void main(String[] args){
        Main m = new Main();
        int[] dp = new int[10];
        Arrays.fill(dp,1);
        System.out.println(dp[0]);
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(str2.length());
        fun(str1);
        fun(str2);
        Thread thread = new Thread();
    }

    public static void fun(String str){
        int length = str.length();
        if(length>=100){
            //return;
        }
        if(length==0){
            System.out.println("");
        }
        int num = 8-length%8;
        for(int i=0;i<(length+num);i++){
            if(i%8 == 0 && i!=0){
                System.out.print("\n");
            }
            if(i<length){
                System.out.print(str.charAt(i));
                continue;
            }
            System.out.print(0);
        }
        System.out.print("\n");
    }
}