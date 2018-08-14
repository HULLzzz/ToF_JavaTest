package com.ToF.test;

/**
 * @Author:
 * @Description:题目： 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。例如数组{3，4, 5, 1, 2 ｝为｛ l1,2,3, 4，5}的一个旋转，该数组的最小值为1
 * @params:
 * @Data: Created in  15:33 2018/8/6
 * @Modified By:
 */
public class Test_08_MinOrder {
    //params : numbers旋转数组 return：数组的最小值
    public static int min(int[] numbers){
        //判断输入是否合法
        if (numbers==null&&numbers.length==0){
            throw new RuntimeException("Invalid input");
        }
        //开始处理第一个位置
        int lo = 0;
        //开始处理最后一个位置
        int hi = numbers.length - 1;
        //设置初始值
        int mi = lo;

        //确保lo在前一个排好序的部分,hi在后一个排好序的部分
        while (numbers[lo]>=numbers[hi]){
            //当处理范围只有两个数据的时候，返回后一个结果
            if (hi-lo==1){
                return numbers[hi]; //后一个结果对应的是最小值
            }
            //取中间位置
            mi = lo + (hi-lo)/2;
            //三个数都相等，则需要进行顺序处理，从头到尾找出最小的值
            if (numbers[mi]==numbers[lo]&&numbers[hi]==numbers[mi]){
                return minInorder(numbers,lo,hi);
            }
            //如果中间位置对应的值在前一个排好序的部分，将lo设置为新的处理为hi之
            if (numbers[mi]>=numbers[lo]){
                lo = mi;
            }
            //如果中间位置对应的值在后一个排好序的部分，将hi设置为新的处理位置
            else if (numbers[mi]<=numbers[hi]){
                hi = mi;
            }
        }
        return numbers[mi];

    }

    private static int minInorder(int[] numbers, int start, int end) {
        int result = numbers[start];
        for (int i = start+1;i<=end;i++){
            if (result>numbers[i]){
                result = numbers[i];
            }
        }
        return result;
    }
}
