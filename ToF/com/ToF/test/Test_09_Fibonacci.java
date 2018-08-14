package com.ToF.test;

/**
 * @Author:
 * @Description:时间O（n）
 * @params:
 * @Data: Created in  15:57 2018/8/6
 * @Modified By:
 */
public class Test_09_Fibonacci {
    public static long fibonacci(int n){
        if(n<=0){
            return 0;
        }
        //输入1或2的时候返回1
        if (n==1||n==2){
            return 1;
        }
        //记录前两个(第n-2个)fibonacci数的值
        long prePre = 1;
        //记录前两个(第n-1个)fibonacci数的值
        long pre = 1;
        //记录前两个(第n个)fibonacci数的值
        long current = 2;
        //求解第n个fibonacci数的值
        for (int i = 3;i<=n;i++){
            current = prePre + pre;
            prePre = pre;
            pre = current;
        }
        return current;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(0));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(2));
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(6));
        System.out.println(fibonacci(7));
    }




}
