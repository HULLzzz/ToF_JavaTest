package com.ToF.test;

/**
 * @Author:
 * @Description:题目：统计一个数字：在排序数组中出现的次数。
 * @params:
 * @Data: Created in  16:26 2018/8/10
 * @Modified By:
 */
public class Test_38_TimesOfNum {
    private static int getFirstK(int[] data,int k,int start,int end){
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }
        int midIdx = start + (end - start)/2;
        int midData = data[midIdx];
        if (midData == k) {
            if (midIdx > 0 && data[midIdx - 1] != k || midIdx == 0) {
                return midIdx;
            }else {
                end = midIdx-1;
            }
        } else if (midData > k) {
            end = midIdx - 1;
        }else {
            start = midIdx + 1;
        }
        return getFirstK(data,k,start,end);
    }

    //找k最后一次出现的位置
    private static int getLastK(int[] data,int k ,int start,int end){
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }
        int midIdx = start+(end-start)/2;
        int midData = data[midIdx];
        if (midData == k) {
            if (midIdx + 1 < data.length && data[midIdx + 1] != k || midIdx == data.length - 1) {
                return midIdx;
            }else {
                start = midIdx + 1;
            }
        } else if (midData < k) {
            start = midIdx + 1;
        }else {
            end = midIdx - 1;
        }
        return getLastK(data,k,start,end);
    }

    //统计一个数字在排序数组中出现的次数
    public static int getNumberOfK(int[] data,int k ){
        int number = 0;
        if (data != null && data.length > 0) {
            int first = getFirstK(data,k,0,data.length-1);
            int last = getLastK(data,k,0,data.length-1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }
        return number;
    }

    public static void main(String[] args) {
        // 查找的数字出现在数组的中间
        int[] data1 = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(data1, 3)); // 4
    }

}
