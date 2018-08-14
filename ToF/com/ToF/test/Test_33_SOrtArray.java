package com.ToF.test;


import java.util.Comparator;

/**
 * @Author:
 * @Description:题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * @params:
 * @Data: Created in  10:35 2018/8/11
 * @Modified By:
 */
public class Test_33_SOrtArray {
    //自定义的排序比较器
     private static class Mcomparator implements Comparator<String> {
         @Override
         public int compare(String o1, String o2) {
             if (o1 == null || o2 == null) {
                 throw new IllegalArgumentException(" invalid input");
             }
             String s1 = o1 + o2;
             String s2 = o2 + o1;
             return s1.compareTo(s2);
         }
     }

     //快排：将数组分为左右部分，左边的比某个指定的数字小，右边的比某个数字大，使用递归再对子数组进行排序 start要排序的起始位置，end要排序的终止位置
    private static void quickSort(String[] array,int start,int end,Comparator<String> comparator){
        if (start < end) {
            String pivot = array[start];
            int left = start;
            int right = end;
            while (start < end) {
                while (start < end && comparator.compare(array[end], pivot) <= 0) {
                    end--;
                }
                array[start] = array[end];
                while (start < end && comparator.compare(array[start], pivot) <= 0) {
                    start++;
                }
                array[end] = array[start];
            }
            array[start] = pivot;
            quickSort(array,left,start-1,comparator);
            quickSort(array,start+1,right,comparator);

        }

    }

    //return输出结果
    public static String printMinNumber(String[] array){
        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("invalid input");
        }
        Mcomparator mcomparator = new Mcomparator();
        quickSort(array,0,array.length-1,mcomparator);
        StringBuilder builder = new StringBuilder(256);

        for (String s:array){
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String[] data3 = {"3", "323", "32123"};
        System.out.println(printMinNumber(data3));
    }

}
