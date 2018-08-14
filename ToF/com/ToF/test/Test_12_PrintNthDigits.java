package com.ToF.test;

/**
 * @Author:
 * @Description:输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
 * @params:
 * @Data: Created in  17:08 2018/8/6
 * @Modified By:
 */
public class Test_12_PrintNthDigits {
    public static void printOneToNthDigits(int n){
        //输入的数字不能小于n
        if (n<1){
            throw new RuntimeException("The input number must larger tahn 0");
        }

        //创建一个数组用于打印存放值
        int[] arr = new int[n];
        printOneToNthDigits(0,arr);
    }

    public static void printOneToNthDigits(int n,int[] arr){
        if (n>=arr.length){
            printArray(arr);
        }else {
            for (int i = 0;i<9;i++){
                arr[n] = i;
                printOneToNthDigits(n+1,arr);
            }
        }
    }

    private static void printArray(int[] arr) {
        //输入数组的元素，从左到右从第一个非0值到开始输出到最后的元素
        int index = 0;
        while (index<arr.length&&arr[index]==0){
            index++;
        }
        //从第一个非0值开始输出到最后的元素
        for (int i = index;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        //条件成立的时候说明数组右非零元素，需要换行
        if (index<arr.length){
            System.out.println();
        }
    }

    //比上一种方法少用内存空间

    public static void printOneToNthDigits2(int n){
        if (n<1){
            throw new RuntimeException("the input number must larger than 0");
        }
        int[] arr = new int[n];
        //为初始元素赋值
        for (int i = 0;i<arr.length;i++){
            arr[i] = 0;
        }

        //求结果
        while (addOne(arr)==0){
            printArray(arr);
        }
    }
    public static int addOne(int[] arr){
        //保存进位值，因为每次最低位加1
        int carry = 1;
        //最低的位置的后一位
        int index = arr.length;
        do{
            //指向上一个处理位置
            index--;
            //处理位置的值加上进位的值
            arr[index] += carry;
            //求处理位置的进位
            carry = arr[index]/10;
            //求处理位置的值
            arr[index] %= 10;
        }while (carry!=0&&index>0);
        //如果index=0说明了已经处理了最高位，carry>0说明最高位有进位，返回1
        if (carry>0&&index==0){
            return 1;
        }
        //无进位，返回0
        return 0;
    }
}
