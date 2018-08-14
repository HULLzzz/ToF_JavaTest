package com.ToF.test;

/**
 * @Author:
 * @Description:题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
 * @params:
 * @Data: Created in  16:02 2018/8/9
 * @Modified By:
 */
public class Test_29_FindNumOverHalf {
    public static int moreThanHalfNum(int[] numbers){
        if (numbers == null || numbers.length < 1) {
            throw new IllegalArgumentException("array length must lager than 0");
        }
        //记录出现次数大于数组一半的数
        int result = numbers[0];
        //与当前记录的数不同的数的个数
        int count = 1;
        //从第二个数开始向后找
        for (int i = 1;i<numbers.length-1;i++){
            if (count == 0){
                result = numbers[i];
                count = 1;
            }
            else if (result == numbers[i]){
                count++;
            }
            else {
                count--;
            }
        }
        count = 0;
        for (int num: numbers){
            if (result==num){
                count++;
            }
        }
        if (count > numbers.length / 2) {
            return result;
        }else {
            throw new IllegalArgumentException("invalid input");
        }
    }

    public static void main(String[] args) {
        int numbers[] = {2,1,2,3,2};
        System.out.println(moreThanHalfNum(numbers));
    }
}
