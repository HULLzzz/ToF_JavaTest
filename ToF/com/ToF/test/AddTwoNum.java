package com.ToF.test;

/**
 * @Author:
 * @Description:求两个整数的和，不能使用加减乘除
 *              思路：使用位运算
 *              例如：7+8  不算进位相加各位的值位5，计算进位10，重复上述两步，只不过相加的值变成了5和10
 * @params:
 * @Data: Created in  16:37 2018/7/25
 * @Modified By:
 */
public class AddTwoNum {

    public static void main(String[] args) {
        System.out.println(Add(32,19));
    }
    public static int Add(int num1,int num2){
        int sum = num1^num2;  //进行异或运算，相加各位的值，不算进位
        int carry = (num1&num2)<<1; //计算进位，如果这一步的进位值为0则结果就是第一步的结果
        //重复上述两步，相加的值变为上述两步的值
        while (carry!=0){
            int tmp = sum;
            sum^=carry;  //sum = sum * carry  num1 = sum num2 = carry
            carry = (carry&tmp)<<1;
        }
        return sum;
    }
}
