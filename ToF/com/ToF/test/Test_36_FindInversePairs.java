package com.ToF.test;

/**
 * @Author:
 * @Description:题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * @params:
 * @Data: Created in  17:12 2018/8/10
 * @Modified By:
 */
public class Test_36_FindInversePairs {
    public static int inversePairs(int[] data){
        if (data == null || data.length < 1) {
            throw new IllegalArgumentException("invalid args");
        }
        int[] copy = new int[data.length];
        System.arraycopy(data,0,copy,0,data.length-1);
        return inversePairsCore(data,copy,0,data.length-1);
    }

    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end-start)/2;
        //注意递归的时候传入的是排序好的数组，避免重复计算
        int left = inversePairsCore(copy,data,start,start+length);
        int right = inversePairsCore(copy,data,start+length+1,end);

        //前半段的最后一个数字的下标
        int i = start + length;
        //后半段的最后一个数字的下标
        int j = end;
        //开始copy的位置
        int indexCopy = end;
        //逆序数
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i]>data[j]){
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count+=j-(start+length); //对应的逆序数
            }else {
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }
        //for缺省表示没有初始值，此时i是上次计算结束后的值
        for (;i>=start;){
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }
        for(;j>=start+length+1;){
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count+left+right;

    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 7, 6, 5};
        System.out.println(inversePairs(data)); // 3
        int[] data2 = {6, 5, 4, 3, 2, 1};
        System.out.println(inversePairs(data2)); //  15
    }

}
