package com.ToF.test;

/**
 * @Author:
 * @Description:
 * @params:
 * @Data: Created in  15:51 2018/7/25
 * @Modified By:
 */
/**
 * 题目：
 * 给定一个数组 A[0, 1, ..., n-1],
 * 请构建一个数组 B[0, 1, ..., n-1],
 * 其中B中的元素 B[i] = A[0] * A[1] * ... * A[i-1] * A[i+1] * ... * A[n-1]。
 * 不能使用除法。
 *
 * 思路：
 * 计算每一个b[j]都将除了a[j]之外的数相乘，时间复杂度为O(n^2)
 * B[0]   =   1  * A[1] * A[2] * ... * A[n-2] * A[n-1]
 * B[1]   = A[0] *   1  * A[2] * ... * A[n-2] * A[n-1]
 * B[2]   = A[0] * A[1] *   1  * ... * A[n-2] * A[n-1]
 * B[n-2] = A[0] * A[1] * A[2] * ... *    1   * A[n-1]
 * B[n-1] = A[0] * A[1] * A[2] * ... * A[n-2] *   1
 *
 * 分割成两个三角形去解决
 *
 * 时间复杂度：O（n)   空间复杂度：O(n)
 */
public class ConstructArray {
    public static void main(String[] args) {
        test1();

    }
    public static void test1(){
        int[] result = multiply(new int[]{1,2,3,4});
        for (int i = 0;i<result.length;i++){
            System.out.print(result[i]+"  ");
        }

    }

    public static int[] multiply(int[] A){
        if(A == null)
            return null;
        if(A.length == 0)
            return new int[0];
        //下部分的三角形
        int[] result = new int[A.length];
        result[0] = 1;
        for (int i = 1;i<A.length;i++){
            result[i] = result[i-1]*A[i-1];
        }
        //上半部分的三角形
        int tmp  = 1 ;
        for (int i = A.length-2;i>=0;i--){
            tmp*=A[i+1];
            result[i] *= tmp;
        }
        return result;
    }

}
