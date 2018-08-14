package com.ToF.test;

import javafx.scene.AccessibleAttribute;

/**
 * @Author:
 * @Description:
 *      题目：给定一个数组A[0,1,…,n-1],请构建一个数组B[0,1,…,n-1],其中B中的元素B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1],不能使用除法。
 *      思路：将相乘矩阵视为两个三角形
 * @params:
 * @Data: Created in  9:56 2018/8/1
 * @Modified By:
 */
public class Test_52_mutiplyMatrix {
    public static void main(String[] args) {
        int[] result = multply(new int[]{1,2,3,4,5});
        for (int i = 0;i<result.length;i++ ){
            System.out.println(result[i]+"   ");
        }
    }

    public static int[] multply(int[] A){
       if (A == null || A.length == 0){
           return null;
       }

       int[] result = new int[A.length];
        result[0] = 1;
        //下部分三角形
        for (int i = 1;i<A.length;i++){
            result[i] = result[i-1]*A[i-1];
        }
        int tmp = 1;
        for (int i = A.length - 2 ;i>=0;i--){
            tmp*=A[i+1];
            result[i] *= tmp;
        }

        return result;
    }

}
