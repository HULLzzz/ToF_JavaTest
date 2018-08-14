package com.ToF.test;

import javax.print.attribute.standard.Finishings;
import java.lang.reflect.Field;

/**
 * @Author:
 * @Description:
 *              题目：输入一个整型数组，数组里有正数也有负数。
 *              数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
 *              要求时间复杂度为O(n)。
 * @params:
 * @Data: Created in  9:12 2018/8/4
 * @Modified By:
 */
public class Test_31_FindMaxSum {
    public static int findGreatestSumOfSubArray(int[] arr){
        //参数校验，我们应该考虑无效的输入，无效输入返回什么值，若返回0的话，如何和最大值是0做区分
        if (arr == null||arr.length<1){
            throw new IllegalArgumentException("Array musr contain an element");
        }
        //记录最大的子数组和，开始的时候是最小的整数
        int max = Integer.MIN_VALUE;
        //当前的和
        int curMax = 0;
        //数组的遍历
        for (int i : arr){
            //当前和小于0，重设当前和
            if (curMax<=0){
                curMax = i;
            }
            //当前和大于0，累加当前和
            else {
                curMax += i;
            }
            //更新到子数组和
            if (max<curMax){
                max = curMax;
            }
        }
        return max;

    }


    //动态规划法
    public static int Find(int[] arr,int n){
        int sum = arr[0];
        int max = arr[0];
        for (int i = 1;i<n;i++){
            sum = getMax(sum+arr[i],arr[i]);
            if (sum>=max)
                max = sum;
        }
        return max;
    }
    public static int getMax(int a,int b){
        return a>b?a:b;
    }

    public static void main(String[] args) {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int[] data2 = {-2, -8, -1, -5, -9};
        int[] data3 = {2, 8, 1, 5, 9};

        System.out.println(Find(data,data.length));

        System.out.println(findGreatestSumOfSubArray(data));
        System.out.println(findGreatestSumOfSubArray(data2));
        System.out.println(findGreatestSumOfSubArray(data3));
    }


}
