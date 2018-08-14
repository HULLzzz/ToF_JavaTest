package com.ToF.test;

/**
 * @Author:
 * @Description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
 *              思路：使用两个指针，一个指针从前往后，一个从后往前，移动的时候遇到奇数偶数就进行交换y
 * @params:
 * @Data: Created in  11:48 2018/8/7
 * @Modified By:
 */
public class Test_14_adjustList {
    public static void reorderOddEven(int[] arr){
        //数组校验
        if (arr==null||arr.length<2){
            return ;
        }
        //从左向右记录偶数的位置
        int start = 0;
        int end = arr.length - 1 ;
        while (start<end){
            //找偶数
            while (start<end&&arr[start]%2!=0){
                start++;
            }
            while (start<end&&arr[end]%2 == 0){
                end--;
            }
            //找到后奇偶交换位置
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }
    }

    public static void printArray(int[] arr){
        if (arr!=null&&arr.length>0){
            for (int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        reorderOddEven(array);
        printArray(array);
    }
}
