package com.ToF.test;

/**
 * @Author:
 * @Description: 求1+2+3....+n，要求不能使用乘除法和for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *               使用递归的思想，判断语句使用&&做截断
 * @params:
 * @Data: Created in  17:00 2018/7/25
 * @Modified By:
 */
public class Accumulate {
    public static void main(String[] args) {
        System.out.println(Sum_solution(4));
    }


    public static int Sum_solution(int n ){
        int sum = 0;
        boolean b = (n>0)&&((sum+=Sum_solution(n-1)+n)>0);
        return sum;
    }


}
