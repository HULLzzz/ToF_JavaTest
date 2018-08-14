package com.ToF.test;

/**
 * @Author:
 * @Description:  题目：不用加减乘除求两个数的和
 * @params:
 * @Data: Created in  14:40 2018/8/2
 * @Modified By:
 */
public class Test_47_arithmetic {
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
